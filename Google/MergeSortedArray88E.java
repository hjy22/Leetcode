package Google;

// https://leetcode.com/problems/merge-sorted-array/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class MergeSortedArray88E {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 }, nums2 = { 2, 5, 6 };
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1, index1 = m-1, index2 = n-1;
        while (index2>=0) {
            if(index1>=0&&nums1[index1]>nums2[index2]){
                nums1[index--]=nums1[index1--];
            }else{
                nums1[index--]=nums2[index2--];
            }
        }
    }
}
