package OOPs.PolyMorphism;

public class Main {
    public static void main(String[] args) {
        Shapes a = new Shapes();
        Shapes c = new Circle();
        Shapes b = new Square();
        Shapes d = new Triangle();
        System.out.println(a.a);
        System.out.println(b.a);
        System.out.println(c.a);
        System.out.println(d.a);
        a.area();
        b.area();
        c.area();
        d.area();
        System.out.println();
    }
}
