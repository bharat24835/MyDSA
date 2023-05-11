package OOPs;

public class A {
    protected  int x;
    public int y;
    private int z;

    public A(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public int sum1(int a, int b){
        return a+b;
    }
    protected int sum2(int a, int b){
        return a+b;
    }
    private int sum3(int a,int b){
        return a+b;
    }


}
