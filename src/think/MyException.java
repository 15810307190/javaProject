package think;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;

import org.junit.Test;
class MException extends Exception{
	public MException(){
		
	}
	public MException(String msg){
		super(msg);
	}
}
class MException2 extends Exception{
	public MException2(){
		
	}
	public MException2(String msg){
		super(msg);
	}
}
public class MyException {
	public static void m() throws MException {
		System.out.println("original from first exception");
		throw new MException("first exception");
	}
	public static void main(String args[]){
		try{
			try{
				m();
			}catch(MException e){
				System.out.println("this is from inner try");
				e.printStackTrace();
				throw new MException2("second exception");
			}
		}catch(MException2 e){
			System.out.println("this is from outer try");
			e.printStackTrace();
		}
		/*
		try{
			throw new NullPointerException("npe");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("1:"+e.getCause()+
			",2:"+e.getClass()+
			",3:"+e.getLocalizedMessage()+
			",4:"+e.getMessage()+
			",5:"+e.getStackTrace());
		}
		*/
//		try {
//			ExtraFeatures.f();
//		} catch (MyException2 e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace(System.out);
//		}
//		try {
//			ExtraFeatures.g();
//		} catch (MyException2 e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace(System.out);
//		}
//		try {
//			ExtraFeatures.h();
//		} catch (MyException2 e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace(System.out);
//			System.out.println("e.val()="+e.val());
//		}
	/*
		try{
			throw new NullPointerException();
		}catch(Exception e){
			//e.printStackTrace();
			LoggingException2.logException(e);
			//System.err.println("catch:"+e);
			//e.printStackTrace();
		}
	}
		for (int i = 0; i < 10; i++) {
			System.out.println("this is out1");
			System.err.println("this is err");
		}
		System.out.println("this is out2");
		
	
		try{
			//f2();
			h2();
		}catch(Exception e){
			//for (StackTraceElement trace : e.getStackTrace()) {
			//	System.out.println(trace.getMethodName());
			//}
			e.printStackTrace();
		}
		*/
	}
	public static void f() throws Exception{
		throw new MException("this is a exception in f()");
	}
	public static void h() throws Exception{
		throw new MException();
	}
	public static void f2() throws Exception{
		try{
			f();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
	}
	public static void h2() throws Exception{
		try {
			h();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw (Exception)e.fillInStackTrace();
		}
	}
	
	@Test
	public void testLog(){
		try{
			throw new LoggingException();
		}catch(Exception e){
			//System.err.println("catch:"+e);
			e.printStackTrace();
		}
		/*
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		*/
	}
}


class LoggingException extends Exception{
	private static Logger logger=Logger.getLogger("LoggingException2");
	public LoggingException(){
		StringWriter trace=new StringWriter();
		//printStackTrace();
		//logger.setLevel(Level.SEVERE);
		//logger.info(trace.toString());
		//logger.severe("000");
		//logger.setLevel(Level.OFF);
		//ConsoleHandler consoleHandler=new ConsoleHandler();
		//consoleHandler.setLevel(Level.FINEST);
		//logger.addHandler(consoleHandler);
		FileHandler fileHandler=null;
		try {
			fileHandler = new FileHandler("c:/testlog%g.log");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		fileHandler.setLevel(Level.INFO);
		fileHandler.setFormatter(new MyLogHander());
		logger.addHandler(fileHandler);
		logger.info(null);
		logger.severe("this is severe");
		logger.warning("this is warning");
	}
}

class MyLogHander extends Formatter{

	@Override
	public String format(LogRecord record) {
		// TODO Auto-generated method stub
		return record.getLevel()+":"+record.getMessage()+":"+record.getLoggerName()+"\n";
	}
	
}
class LoggingException2{
	private static Logger logger=Logger.getLogger("LoggingException2");
	static void logException(Exception e){
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}
class MyException2 extends Exception{
	private int x;
	public MyException2(){}
	public MyException2(String msg){super(msg);}
	public MyException2(String msg,int x){
		super(msg);
		this.x=x;
	}
	public int val(){return x;}
	public String getMessage(){
		return "Detail Message:"+x+" "+super.getMessage();
	}
}
class ExtraFeatures{
	public static void f() throws MyException2{
		System.out.println("throwing myexception2 from f()");
		throw new MyException2();
	}
	public static void g() throws MyException2{
		System.out.println("throwing myexception2 from g()");
		throw new MyException2("g()");
	}
	public static void h() throws MyException2{
		System.out.println("throwing myexception2 from h()");
		throw new MyException2("h()",47);
	}
}
