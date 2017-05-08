package think;
interface Destination{
	public String readLabel();
}
interface Game{boolean move();}
interface GameFactory{Game getGame();}
class Checkers implements Game{
	private Checkers(){}
	private int moves=0;
	private static final int MOVES=3;
	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		System.out.println("checkers move"+moves);
		return ++moves!=MOVES;
	}
	public static GameFactory factory = new GameFactory(){

		@Override
		public Game getGame() {
			// TODO Auto-generated method stub
			return new Checkers();
		}
		
	};
	
}
class Chess implements Game{
	private Chess(){}
	private int moves=0;
	private static final int MOVES=4;
	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		System.out.println("chess move"+moves);
		return ++moves!=MOVES;
	}
	public static GameFactory factory = new GameFactory(){

		@Override
		public Game getGame() {
			// TODO Auto-generated method stub
			return new Chess();
		}
		
	};
	
}
abstract class Base{
	{System.out.println("this is what?");}
	public Base(int i){
		System.out.println("base constructor,i="+i);
	}
	public abstract void f();
}
public class InnerClass {
	public static void playGamme(GameFactory factory){
		Game s = factory.getGame();
		while(s.move()){}
	}
	/**
	 * this i can't set final.because we can't use i 
	 * in innerClass rather than transfer it to supper class.
	 */
	public static Base getBae(int i){
		return new Base(i){
			{
				System.out.println("inside instance initializer");
			}
			public void f(){
				
			}
		};
	}
	/**
	 *outerClass static method visit innerClass use outerClass
	 *outerClass others only use innerClass 
	 */
	private String Oname;
	private int age;
	private static int ages;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//InnerClass ic=new InnerClass();
		//Destination dt=ic.destination("test");
		//dt.readLabel();
		//int a=new siC().sage;
		//int s=siC.sage2;
		playGamme(Checkers.factory);
		playGamme(Chess.factory);
		//Base base=getBae(47);
		//base.f();
	}
	/**
	 * static innerClass can't visit outerClass's ordinary variable
	 * static innerClass's ordinary variables should new himself
	 */
	static class siC{
		int sage=10;
		static int sage2=2;
		public siC(){
			
		}
		public int getMember(){
			return ages+sage2;
		}
	}
	/**
	 *member innerClass use all outer method
	 */
	class Iclass{
		static final int sage=10;
		String name;
		int age;
		public Iclass(String name,int age){
			this.name=name;
			this.age=age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = Oname;
		}
		/**
		 * inner and outer has same variables
		 * this.var and outerClass.this.var can erase this conflict
		 */
		public int getAge() {
			return this.age+InnerClass.this.age;
		}
		public void setAge(int age) {
			this.age = age;
		}
	}
	public Iclass getIC(String msg){
		return new Iclass(msg,10);
		
	}
	public Destination destination(final String s){
		/**
		 * local innerClass can use outerClass's member variable
		 * but local var must use final
		 */
		final int methodInner=10;
		class PDestination implements Destination{
			private String label;
			private PDestination(String whereTo){
				label = whereTo+s;
			}
			public String readLabel(){
				return label+methodInner+Oname;
			}
		}
		return new PDestination(s);
	}

}
