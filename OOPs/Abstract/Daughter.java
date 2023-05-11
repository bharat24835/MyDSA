package OOPs.Abstract;

public class Daughter extends Parent {
    @Override
    void carrer(String name) {
        System.out.println(name);
    }

    @Override
    void partner(String name, int age) {
        System.out.println(name + " " + age );

    }
}
