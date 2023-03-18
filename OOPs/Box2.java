package OOPs;

public class Box2 extends Box1{
    int w;

    public Box2(int l, int b, int h, int w) {
        super(l, b, h,w);   // l =1  , b = 2  , h = 3 , w = 4; // call constructor of SuperClass(Box1)
        this.w = w+1;   // variable "w" of class Box2 is intialised
        System.out.println(this.w);  // this will print value of variable "w" of class Box2
        System.out.println(super.w); // this will print value of variable "w" of class Box1
    }

    public static void main(String[] args) {
        Box2 b1 = new Box2(1,2,3,4); // call constructor of Box 2
        // since we know variable 'b1' have access to its superclass(Box1) instance variable
        // here class Box1 and class Box2 have both same variable name i.e "w"

        System.out.println(b1.l);   // OP = 1
        System.out.println(b1.b);   // op = 2
        System.out.println(b1.h);   // OP = 3
        System.out.println(b1.w);   // OP = 5 // this will print the value of "w" of class BOX2 (child class)
        // So , my doubt is , how we can access the superclass variable "w" from variable 'b1'

       // since of variable 'b1' is of type Box2 , it can access its superclass member also
    }
}
