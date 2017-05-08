package think;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/4/10.
 */
class ADaemon implements Runnable{
    public void run(){
        try{
            System.out.println("starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("this should always run?");
        }
    }
}
public class FinalThread {
    public static void main(String[] args)throws Exception{
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
        TimeUnit.SECONDS.sleep(2);
    }
}
