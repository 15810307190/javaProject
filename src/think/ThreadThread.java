package think;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/4/10.
 */
class Daemon implements Runnable{
    private Thread[] t = new Thread[10];
    @Override
    public void run() {
        for(int i =0; i<t.length; i++){
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn"+i+"started,");
        }
        for(int i=0; i<t.length; i++){
            System.out.println("t[" + i + "].isDaemon() =" +
            t[i].isDaemon() + ",");
        }
        while (true){

        }
            //Thread.yield();
    }
}
class DaemonSpawn implements Runnable{
    public void run(){
        while (true){

        }
            //Thread.yield();
    }
}
public class ThreadThread {
    public static void main(String[] args)throws Exception{
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon()="+d.isDaemon()+",");
        TimeUnit.SECONDS.sleep(1);
    }
}
