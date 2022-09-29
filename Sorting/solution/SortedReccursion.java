package com.company;

public class SortedReccursion {
    public static void main(String[] args) {
        System.out.println(" here we wish to check whether is array is sorted or not usign recurssion: ");
        int []a = {1,2,3,2,4,5};
        int count =0;
        System.out.println(" Array is sorted : " + sort(a,count));

    }
    public static boolean sort( int []a , int index)
    {
        if(index==a.length-1)
            return  true;
        return (a[index] < a[index+1] && sort(a,++index));


    }

}
