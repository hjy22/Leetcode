package Tiktok2025;

// https://leetcode.com/problems/find-peak-element/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class FindPeakElement162M {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid]<=nums[mid+1]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
