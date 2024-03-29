package Array;

import java.util.Arrays;
//https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArrayE88 {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] nums2 = { 2, 5, 6 };
        int n = 3;
        merge(nums1, m, nums2, n);
        for(int i =0;i<nums1.length;i++){
            System.out.print(nums1[i]+" ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=0;
        for(int i=m;i<nums1.length;i++){
            nums1[i]=nums2[index];
            index++;
        }
        Arrays.sort(nums1);
    }
}
