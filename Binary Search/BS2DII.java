package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class BS2DII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [][]a = {
                { 1,2,3,4},
                { 5,6,7,8},
                { 9,10,11,12},
                { 13,14,15,16}
        };
        System.out.println(" Enter the target : ");
        int target = in.nextInt();
        System.out.println(" Target Is : " + target);
        System.out.println(" We want to search in 2D array using ignoring rows method");
         int [] ssp = SearchSpace(a,target);
         // we have to take total three items in array that show rowstart, rowend and mid column
         int rStart = ssp[0];
         int rEnd = ssp[1];
        System.out.println(" Checking whether the mid col has target element or not");
        int cMid = ssp[2];
       // int count =0;
        if(a[rStart][cMid] == target)
        {
            System.out.println(" Found the element at index : [ "+ rStart+" , " + cMid+ " ]");
            //count=1;
        }
         else if(a[rEnd][cMid] == target)
        { //count=1;
            System.out.println(" Found the element at index : [ "+ rEnd+" , " + cMid+" ]");
        }
         else
        {
            System.out.println(" Now we have to search in 4 different parts: ");
            SearchOperation(a, target, rStart,rEnd ,cMid);
        }
    }
    static int[] SearchSpace(int[][]a, int target)
    {
        int rStart =0;
        int rEnd =a.length-1;
        int cStart = 0;
        int cEnd = a[0].length-1;
        int cMid = cEnd/2;
        while( rStart < rEnd-1) // since we need two pair of rows
            // and due to this rMid never goes to last row
            // hence no index out of bond length  for (rMid+1) line 64:
        {
            int rMid = rStart + (rEnd - rStart)/2;
            if(a[rMid][cMid] > target)
            {
                rEnd = rMid;
            }
            else if (a[rMid][cMid] < target)
            {
                rStart = rMid;
            }
            else
            {
                rStart = rMid;
                rEnd = rMid+1;
                break;
            }
        }
        System.out.println(" Our searching space is : ");
        System.out.println(" rStart: " + rStart);
        System.out.println(" rEnd: " + rEnd);

        // checking whether the mid has target value or not
       //if(a[rStart][cMid]== target)

           return new int[]{rStart,rEnd,cMid};
    }
     static void SearchOperation(int[][]a,int target,int rStart,int rEnd ,int cMid)
    {
        int cMax =( a[0].length-1);

        System.out.println(" cMax " + cMax);
        int[]b = new int[2];
        if(a[rStart][cMid] > target) // left upper row
        {
            System.out.println(" I st part");
            b = BS(a,target,0,cMid-1,rStart);// rStart denotes which row
        }
         if(a[rStart][cMid] <  target && target < a[rEnd][0])// right upper row
        {
            System.out.println(" IInd part");
            b = BS(a,target,cMid+1,a[0].length-1,rStart);
        }
         if (a[rEnd][cMid] > target && target >= a[rEnd][0] ) // left down row
        {
            System.out.println(" IIIrd part");
            b = BS(a,target,0,cMid-1,rEnd);
        }
        if(a[rEnd][cMid] < target )// right down row
         {
             System.out.println(" IVth  part");
            b = BS(a,target,cMid+1,a[0].length-1,rEnd);
        }
        System.out.println(" We have found the element at index : " + Arrays.toString(b));
    }
     static int[] BS(int [][]a, int target, int start, int end ,int whichrow)
    {

       while(start <= end)
       {
           int mid = start + (end - start)/2; // yeh wali line hamesh yaaad rahegi
           if (a[whichrow][mid] > target)
               end = mid - 1;
           else if (a[whichrow][mid] < target)
               start = mid + 1;
           else
               return new int[]{whichrow, mid};
       }
       return new int[] {-1,-1};
    }

}
