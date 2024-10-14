package Tiktok;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
//要记得判断start和end是不是valid的
public class FindFirstandLastPositionofElementinSortedArray34M {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] ans = searchRange(nums, target);
        System.out.println(ans[0]+" "+ans[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = findStart(nums, target);
        int end = findEnd(nums, target);
        if(start <= end && end < nums.length&&nums[start]==target&&nums[end]==target){
            return new int[]{start,end};
        }
        return new int[]{-1,-1};
    }

    public static int findStart(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid]>=target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public static int findEnd(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return right;
    }
}
