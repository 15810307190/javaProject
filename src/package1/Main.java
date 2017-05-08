package package1;
import package2.fieldParentSon;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class Main {
    /*field myfield=new field();
    public void deal1(){
        myfield.printC();
        myfield.printB();
    }*/
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner s=new Scanner(new My());
        while (s.hasNext()){
            System.out.print(s.next()+" ");
        }
    }
}
class My implements Readable{
    private int count=10;
    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count--==0){
            return -1;
        }
        String string=Double.toString(new Random(55).nextDouble());
        cb.append(string);
        return cb.length();
    }
}
interface i1{
    void f();
}
interface i2{
    int f(int i);
}
interface i3{
    int f();
}
class c{
    public int f(){
        return 1;
    }
}
class c2 implements i1,i2{

    @Override
    public void f() {

    }

    @Override
    public int f(int i) {
        return 1;
    }
}
class c5 extends fieldParent{
    @Override
    protected void setA(int a) {
        super.setA(a);
    }
}
class c3 extends c implements i2{

    @Override
    public int f(int i) {
        return 0;
    }
}
class c4 extends c implements i3{

}