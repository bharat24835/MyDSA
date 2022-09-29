package Bharat;

import java.util.Scanner;

public class Dice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Here we wish to print the dice prboelem that asked in amazon: ");
        int target = 4;
        String ans=  "";
        call(ans, target);
    }
    public static void call( String ans, int target)

    {

        if(target==0)
        {
            System.out.println(ans);
        }

        for (int i=1; i<=6 && i<=target; i++)
        {
            call(ans+i, target-i);
        }

    }

}
