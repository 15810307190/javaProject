package think;
class DynamicFieldsException extends Exception{}
public class ExceptionChain {
	private Object[][] fields;
	public ExceptionChain(int initialSize){
		fields= new Object[initialSize][2];
		for (int i = 0; i < initialSize; i++) {
			fields[i]=new Object[]{null,null};
		}
	}
	public static void main(String args[]){
		ExceptionChain ec=new ExceptionChain(3);
		System.out.println(ec);
		try{
			ec.setField("d", "A  value for d");
			ec.setField("number", 47);
			ec.setField("number2", 48);
			System.out.println(ec);
			ec.setField("d", "A new value for d");
			ec.setField("number3", 11);
			System.out.println("ec:"+ec);
			System.out.println("ec.getField(\"d\"):"+ec.getField("d"));
			Object field=ec.setField("d",null);
		}catch(NoSuchFieldException e1){
			e1.printStackTrace();
		}catch(DynamicFieldsException e2){
			e2.printStackTrace();
		}
	}
	public String toString(){
		StringBuilder result = new StringBuilder();
		for(Object[] obj:fields){
			result.append(obj[0]);
			result.append(":");
			result.append(obj[1]);
			result.append("\n");
		}
		return result.toString();
	}
	private int hasField(String id){
		for(int i=0;i<fields.length;i++)
			if(id.equals(fields[i][0]))
				return i;
		return -1;
	}
	private int getFieldNumber(String id) throws NoSuchFieldException{
		int fieldNum = hasField(id);
		if(fieldNum == -1)
			throw new NoSuchFieldException();
		return fieldNum;
	}
	private int makeField(String id){
		for(int i=0;i<fields.length;i++)
			if(fields[i][0] == null){
				fields[i][0]=id;
				return i;
			}
		Object[][] tmp = new Object[fields.length+1][2];
		for(int i=0;i<fields.length;i++){
			tmp[i]=fields[i];
		}
		for(int i =fields.length;i<tmp.length;i++)
			tmp[i]=new Object[]{null,null};
		fields=tmp;
		return makeField(id);
	}
	public Object getField(String id) throws NoSuchFieldException{
		return fields[getFieldNumber(id)][1];
	}
	public Object setField(String id,Object value)throws DynamicFieldsException{
		if(value==null){
			DynamicFieldsException dfe = new DynamicFieldsException();
			dfe.initCause(new NullPointerException());
			throw dfe;
		}
		int FieldNumber=hasField(id);
		if(FieldNumber==-1)
			FieldNumber=makeField(id);
		Object result=null;
		try{
			result=getField(id);
		}catch(NoSuchFieldException e){
			throw new RuntimeException(e);
		}
		fields[FieldNumber][1]=value;
		
		return result;
	}
	
}
