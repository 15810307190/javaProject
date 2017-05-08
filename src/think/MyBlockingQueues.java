package think;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/5/8.
 */
class LiffOffRunner implements Runnable{
    private BlockingQueue<LiftOff> rockets;
    public LiffOffRunner(BlockingQueue<LiftOff> lf){
        this.rockets=lf;
    }
    public void add(LiftOff lo){
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                LiftOff lo = rockets.take();
                lo.run();
            }
        }catch (InterruptedException e) {
                System.out.println("has a problems");
        }
        System.out.print("leave LiffOffRunner");
    }
}
public class MyBlockingQueues {
    static void getKey(){

    }
    static void getKey(String msg){
        System.out.println(msg);
        //getKey();
    }
    static void test(String msg,BlockingQueue<LiftOff> queue){
        System.out.println(msg);
        LiffOffRunner lr= new LiffOffRunner(queue);
        Thread thread = new Thread(lr);
        thread.start();
        for (int i=0;i<5;i++){
            lr.add(new LiftOff(5));
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getKey("get key ok -------------");
        thread.interrupt();
        System.out.println("has finished");
    }
    public static void main(String args[]){

        test("linkedblockqueue",new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlockQueue",new ArrayBlockingQueue<LiftOff>(3));
        test("linkedblockqueue",new SynchronousQueue<LiftOff>());
    }

}
