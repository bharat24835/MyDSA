package OOPs.PolyMorphism;

import OOPs.A;

public class SubClass  extends A {

    public SubClass(int x, int y, int z) {
        super(x, y, z);
    }
    public static void main(String[] args) {
        A obj = new SubClass(1,2,3);
       // System.out.println(obj.x);
        System.out.println(obj.y);
        //  System.out.println(obj.z); not access as this is private
        System.out.println(obj.sum1(1,1));
      //  System.out.println(obj.sum2(1,1));
        //  System.out.println(obj.sum3(1,1)); not acces as this is private


    }

}
