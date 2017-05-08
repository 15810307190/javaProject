package think;


class BaseballException extends Exception{}
class Foul extends BaseballException{}
class Strike extends BaseballException{}
abstract class Inner{
	Inner()throws BaseballException,NullPointerException{}
	public void event()throws BaseballException{}
	public abstract void atBat()throws Foul,Strike;
	public void walk(){}
}
class StormException extends Exception{}
class RainedOut extends StormException{}
class PopFoul extends Foul{}

interface Storm{
	public void event()throws RainedOut,BaseballException;
	public void rainHard()throws RainedOut;
}


public class StormInner  extends Inner implements Storm{

	StormInner() throws RainedOut,BaseballException {
		// TODO Auto-generated constructor stub
		throw new RainedOut();
	}
	StormInner(String msg) throws Foul,BaseballException {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void rainHard() throws RainedOut {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void event(){
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void atBat() throws PopFoul {
		// TODO Auto-generated method stub
		throw new PopFoul();
		
	}
	public static void main(String args[]){
		try {
			StormInner si=new StormInner();
			si.atBat();
		} catch (PopFoul e) {
			// TODO Auto-generated catch block
			System.out.println("pop foul");
		} catch (RainedOut e) {
			// TODO Auto-generated catch block
			System.out.println("rained out");
		} catch (BaseballException e) {
			// TODO Auto-generated catch block
			System.out.println("baseball exception");
		}
		try {
			Inner i=new StormInner();
			i.atBat();
		} catch (RainedOut e) {
			// TODO Auto-generated catch block
			System.out.println("rained out");
		} catch (Foul e) {
			// TODO Auto-generated catch block
			System.out.println("foul");
		} catch (Strike e) {
			// TODO Auto-generated catch block
			System.out.println("strike");
		} catch (BaseballException e) {
			// TODO Auto-generated catch block
			System.out.println("baseball exception");
		}
	}
}
