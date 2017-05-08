package think;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/4/10.
 */
class DaemonThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
public class DaemonFromFactory implements Runnable {
    @Override
    public void run() {
        try{
            //while (true){
            //    TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+""+this);
            //}
        }catch (Exception e){
            System.out.print("interrupted");
        }
    }
    public static void main(String[] args)throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for(int i=0;i<10;i++) {
            exec.execute(new DaemonFromFactory());
            Thread.sleep(1000);
        }
        System.out.println("all daemons started");
        //TimeUnit.MILLISECONDS.sleep(5000);
    }
}
