package OOPs.Abstract;

public class Main {
    public static void main(String[] args) {
        Son son = new Son();
        son.carrer("Doctor");

        Daughter daughter = new Daughter();
        daughter.carrer("Enginner");
        Parent.call();

    }
}
