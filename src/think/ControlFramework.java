package think;

import java.util.ArrayList;
import java.util.List;
class Out{
	class Inner{
		
	}
}
class InheritInner extends Out.Inner{

	public InheritInner(Out out) {
		// TODO Auto-generated constructor stub
		out.super();
	}
}
abstract class Event{
	private long eventTime;
	protected final long delayTime;
	public Event(long delayTime){
		this.delayTime=delayTime;
		start();
	}
	private void start() {
		// TODO Auto-generated method stub
		eventTime=System.nanoTime()+delayTime;
	}
	public boolean ready(){
		return System.nanoTime()>=eventTime;
	}
	public abstract void action();
	
}
public class ControlFramework {

	/**
	 * @param args
	 */
	private List<Event> list=new ArrayList<>();
	public void addEvent(Event e){
		list.add(e);
	}
	public void run(){
		while(list.size()>0){
			for (Event e : new ArrayList<Event>(list)) {
				if(e.ready()){
					System.out.println(e);
					e.action();
					list.remove(e);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Event ev=new Event(300000) {
			
			@Override
			public void action() {
				// TODO Auto-generated method stub
				while(!ready()){
					try {
						Thread.sleep(1000);
						System.out.println("is sleeping");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("this is event");
			}
		};
		ev.action();
		*/
	}

}
