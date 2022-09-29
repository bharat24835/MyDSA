package com.company;

public class StringConcept {
    public static void main(String[] args) {
        System.out.println(" First we check how a, b,c stored in memoruy");
        String a = "Bharat";  // value stores in pool
        String b = new String("Bharat"); // new obeject created

        System.out.println(a==b);// not pointing to same object

        String c = "Bharat"; // since this already stored in pool
        // so simply c will point out same value in pool

        System.out.println(a==c);// pointing to same obeject
        // thus new keyword is used to create new obeject in heap but out of the pool
        System.out.println(" Now we check only value of a,b,c");
        System.out.println(" using only .equals method : ");
        String d = new String("Bharat");
        System.out.println(a.equals(d));
        System.out.println(a.equals(c));
    }
}
