package think;

import org.junit.Test;

public class TestUtils {
	@Test
	public void test1(){
		Object[][] fields=new Object[2][2];
		for (int i = 0; i < fields.length; i++) {
			fields[i]=new Object[]{null,null};
		}
		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields[i].length; j++) {
				System.out.println(fields[i][j]);
			}
		}
		StringBuilder result = new StringBuilder();
		for(Object[] obj: fields){
			result.append(obj[0]);
			result.append(":");
			result.append(obj[1]);
			result.append("\n");
		}
		System.out.println(result.toString());
		System.out.println(result.toString());
	}
}
