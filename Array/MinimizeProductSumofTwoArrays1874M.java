package Array;

import java.util.Arrays;

//https://leetcode.com/problems/minimize-product-sum-of-two-arrays/
public class MinimizeProductSumofTwoArrays1874M {
    public static void main(String[] args) {
        int[] nums1 = { 5,3,4,2 };
        int[] nums2 = { 4,2,2,5 };
        System.out.println(minProductSum(nums1,nums2));
    }

    public static int minProductSum(int[] nums1, int[] nums2) {
        int ans = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i=0;i<nums1.length;i++){
            ans+=nums1[i]*nums2[nums1.length-i-1];
        }
        return ans;
    }
}
