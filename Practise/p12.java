package Practise;

public class p12 {
    static class  Test{
        String name;
        Test(String a ){
            this.name = a;
        }
    }
    public static void main(String[] args) {
        Test bharat = new Test("Bharat");
        Test shard  = new Test("Sharad");
        System.out.println(bharat.name);
        System.out.println(shard.name);
    }
}
