package Heaps;

public class H1 {
    public static void main(String[] args) throws Exception {
        System.out.println(" Here we do some heap algo: " );
        Max_Heap a  = new Max_Heap(5);
        a.insert(10);
        a.insert(120);
        a.insert(30);
        a.insert(40);
        a.insert(23);
        a.display();
        a.Build_Heap();
        a.display();
        System.out.println("First extracMax : - "+  a.extractMax());
        a.display();
        System.out.println( " Second extractMax : - " + a.extractMax());
        a.display();
        System.out.println(  "Third extractMax : - " + a.extractMax());
        a.display();
    }
}
