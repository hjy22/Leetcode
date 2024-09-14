package Top105;

// https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
public class MergeSortedArray88E {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] nums2 = { 2, 5, 6 };
        int n = 3;
        merge(nums1, m, nums2, n);
        for(int i:nums1){
            System.out.print(i+" ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 =m - 1, index2 = n - 1;
        int p = nums1.length - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] < nums2[index2]) {
                nums1[p] = nums2[index2];
                index2--;
            } else {
                nums1[p] = nums1[index1];
                index1--;
            }
            p--;
        }
        while (index2 >= 0) {
            nums1[p] = nums2[index2];
            p--;
            index2--;
        }
    }
}
