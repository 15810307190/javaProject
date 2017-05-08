package think;

public class MulMain {
	static void f1(){
		System.out.println("hello world");
	}
	static void f2(){
		System.out.println("hello world2");
	}
	/**
	 *	put main into innerClass,
	 *	but when we compile it ,select one main outer$inner
	 *	whatever how many innerClass,innerClass will use outerClass transparent
	 */
	public static class InnerClass{
		public static void main(String[] args){
			f1();
		}
	}
	public static class InnerClass2{
		public static void main(String[] args){
			f2();
		}
	}

}
