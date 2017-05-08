package think;
interface Incrementable{
	void increment();
}
class Callee1 implements Incrementable{
	int i=0;
	@Override
	public void increment() {
		// TODO Auto-generated method stub
		i++;
		System.out.println(i);
	}
	
}
class MyIncrement{
	public void increment(){
		System.out.println("MyIncrement--->increment");
	}
	static void f(MyIncrement my){
		my.increment();
	}
}
class Callee3 extends MyIncrement implements Incrementable{
	
}
class Callee2 extends MyIncrement{
	private int i=0;
	public void increment(){
		super.increment();
		i++;
		System.out.println(i);
	}
	private class Closure implements Incrementable{

		@Override
		public void increment() {
			// TODO Auto-generated method stub
			/**
			 * ֱ�ӵ���callee2�ķ������Ϳ����ˣ�
			 */
			Callee2.this.increment();
		}
		
	}
	public Incrementable getClosure(){
		return new Closure();
	}
}
class Caller {
	private Incrementable callbackReference;
	Caller(Incrementable in){
		callbackReference=in;
	}
	void go(){
		callbackReference.increment();
	}
}
public class closure {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Callee1 c1=new Callee1();
		Callee2 c2=new Callee2();
		Callee3 c3=new Callee3();
		c3.increment();
		//c2.increment();
		//MyIncrement.f(c2);
		Caller caller1=new Caller(c1);
		Caller caller2=new Caller(c2.getClosure());
		caller1.go();
		caller1.go();
		caller2.go();
		caller2.go();
	}

}
