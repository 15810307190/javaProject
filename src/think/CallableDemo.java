package think;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/4/9.
 */
class TaskWithResult implements Callable<Integer>{
    private int id;
    public TaskWithResult(int id){
        this.id=id;
    }
    @Override
    public Integer call() throws Exception {
        Thread.sleep(5000);
        return id;
    }
}
public class CallableDemo {
    public static void main(String args[]){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results=new ArrayList<Future<Integer>>();
        for (int i=0;i<10;i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for (Future<Integer> fs:
             results) {
            try {
                System.out.println(fs.isDone());
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }
}
