package OOPs;

public class b2  extends b1{
    int w;

    public b2(int l, int b, int h, int w) {
        super(l, b, h);
        this.w = w;
    }

    public static void main(String[] args) {
        b2 a = new b2(1,2,3,4);
     //   System.out.println(a.l);
        System.out.println(a.b);
        System.out.println(a.h);
        System.out.println(a.w);
    }
}
