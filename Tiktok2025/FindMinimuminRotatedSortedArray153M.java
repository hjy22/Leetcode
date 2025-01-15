package Tiktok2025;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class FindMinimuminRotatedSortedArray153M {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid]>nums[right]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}
