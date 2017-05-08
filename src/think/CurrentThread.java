package think;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/4/10.
 */
class Mythread implements Runnable{

    @Override
    public void run() {
        try {
            //Thread.sleep(4000);
            System.out.println(Thread.currentThread()+""+this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public class CurrentThread {
    public static void main(String args[]) throws InterruptedException {
        //System.out.println(Thread.currentThread());

        ExecutorService exc = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++) {
            exc.execute(new Mythread());
            Thread.sleep(1000);
        }

        for (int i =0;i<5;i++){
            Thread thread = new Thread(new Mythread());
            thread.setDaemon(true);
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
