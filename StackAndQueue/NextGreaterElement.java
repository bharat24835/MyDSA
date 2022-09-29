package StackAndQueue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int []a = {6,8,2,4,6,9,7,6};
        System.out.println(Arrays.toString(nextGreaterElements(a)));

    }
    public static int[] nextGreaterElements(int[] a) {

        int [] nge = new int[a.length];
        Stack<Integer> st = new Stack <>();
        int n = a.length;
        for(int i = 2*n-1; i>=0 ; i--){

            while(st.empty()==false && st.peek()<=a[i%n])
            { st.pop();
            }
            if(i<n){
                if(st.empty()==false)
                    nge[i] = st.peek();
                else
                    nge[i]=-1;
            }
            st.push(a[i%n]);
        }
        return nge;

    }
}
