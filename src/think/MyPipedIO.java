package think;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/5/8.
 */
public class MyPipedIO {
    public static void main(String args[]){
        writer w=new writer();
        reader r=new reader(w);
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(w);
        es.execute(r);
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        es.shutdownNow();
    }
}
class writer implements Runnable{
    private PipedWriter out = new PipedWriter();

    public PipedWriter getOut() {
        return out;
    }

    @Override
    public void run() {
        try{
            while (true){
                for(char i='A';i<'Z';i++){
                    out.write(i);
                    System.out.println("write"+i);
                    Thread.sleep(500);
                }
            }
        }catch (Exception e){
            System.out.println("writer has finished");
        }
    }
}
class reader implements Runnable{
    private PipedReader reader;
    public reader(writer w){
        try {
            this.reader=new PipedReader(w.getOut());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        try {
            while(true){
                System.out.println("read"+(char)(reader.read()));
            }
        }catch (IOException e) {
            System.out.println("reader has finished");
        }
    }
}
