package think;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/5/8.
 */
public class Chopstick {
    private boolean taken = false;
    public synchronized void take() throws InterruptedException {
        while (taken){
            wait();
        }
        taken=true;
    }
    public synchronized void drop(){
        taken=false;
        notifyAll();
    }
}
class Philosopher implements Runnable{
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random rand=new Random(66);
    public Philosopher(Chopstick left,Chopstick right,int id,int ponderFactor){
        this.left=left;this.right=right;this.id=id;this.ponderFactor=ponderFactor;
    }
    private void pause() throws InterruptedException {
        if(ponderFactor==0)return;
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor*250));
    }
    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                System.out.println(this+" "+"thinking");
                pause();
                System.out.println(this+" "+"grabbing right");
                right.take();
                System.out.println(this+" "+"grabbing left");
                left.take();
                System.out.println(this+" "+"eating");
                pause();
                right.drop();
                left.drop();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String toString(){
        return "Philosopher"+id;
    }
}

