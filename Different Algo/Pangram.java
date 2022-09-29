package com.company;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.Scanner;

public class Pangram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Enter the string:");
        String a= in.nextLine();
        int y = a.length();
        int index = 0;
        int p=0;
        boolean b[]= new boolean[100];

        for (int i = 0; i < y; i++) {
        //for lowercase
            if (a.charAt(i)>='a' && a.charAt(i)<='z')
            {
                index= a.charAt(i)-'a';
                b[index]=true;
            }
            else if(a.charAt(i)>='A' && a.charAt(i)<='Z')
            {
                index= a.charAt(i)-'A';
                b[index]=true;
            }
            else
                b[index]=false;

        }
        for (int i = 0; i < 26; i++) {
            if (b[i] == false) {
                p = 0;
                break;
            } else
                p = 1;
        }
          if (p==0)
             System.out.println("false condition:");
          else
              System.out.println("True condition:");
        System.out.println(a.length());


    }
}
