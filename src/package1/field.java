package package1;

/**
 * Created by Administrator on 2017/3/25.
 */
public class field {
    int a;
    public static void main(String args[]){
        /*fieldSon sf=new fieldSon();
        sf.printA();
        final int[] a=null;
        System.out.println(a[0]);*/
        double a=10;
    }
    protected void setA(int a){
        this.a=a;
    }
    void setA2(int a){
        this.a=a;
    }
    protected fieldParent getP(){
        return new fieldParent();
    }
    protected void printA1(int i){
        System.out.println("int"+i);
    }
    protected void printA1(float i){
        System.out.println("float"+i);
    }
    /*
    protected void printA1(double i){
        System.out.println(i);
    }*/
    protected void printA(int a){
        System.out.println("hello");
    }
    void printB(){
        System.out.println("hello");
    }
    public void printC(){
        System.out.println("hello");
    }
    public field(){

    }
}
class fieldParent{
    public final int f=9;
    public final int f2;
    public static final int f3=5;
    fieldParent(){
        //f=10;
        f2=10;
    }

    private int a;
    protected void setA(int a){
        this.a=a;
    }
    public int getA(){
        return a;
    }
}
class fieldSon extends fieldParent{
    public void printA(){
        setA(10);
        System.out.println(getA());
    }
}
