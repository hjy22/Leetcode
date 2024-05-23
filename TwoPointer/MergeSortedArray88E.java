package TwoPointer;

import java.util.Arrays;

public class MergeSortedArray88E {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        for(int ele:nums1){
            System.out.println(ele);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int left=m-1,right=n-1,p = nums1.length-1;
        while(left>=0&&right>=0){
            if(nums1[left]>nums2[right]){
                nums1[p]=nums1[left];
               
                left--;
            }else{
                nums1[p]=nums2[right];
                right--;
            }
            p--;
        }
        while (right >= 0) {
            nums1[p] = nums2[right];
            right--;
            p--;
        }
    }
}
