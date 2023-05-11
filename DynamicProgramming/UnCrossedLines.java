package DynamicProgramming;

public class UnCrossedLines {
    public static void main(String[] args) {
        int []nums1 = {1,3,7,1,7,5};
        int []nums2 = {1,9,2,5,1};
        System.out.println(" Answer is  : " + call(nums1.length-1, nums2.length-1, nums1, nums2));
    }
    public static int call(int i , int j , int[]nums1, int[]nums2){
        if(i <0 || j< 0) return 0;
        if(nums1[i] == nums2[j]){
            return  1 + call(i-1, j-1,nums1,nums2);
        }
        else{
            return Math.max(call(i-1,j,nums1,nums2), call(i,j-1, nums1,nums2));
        }
    }
}
