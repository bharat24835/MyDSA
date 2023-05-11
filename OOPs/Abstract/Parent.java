package OOPs.Abstract;

public abstract class Parent {
    abstract void carrer(String name);
    abstract void partner(String name, int age);
    static void call(){
        System.out.println("WE can create static method in Abstarct class");
    }
}
