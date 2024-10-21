package SuiXiangLu;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class andLastPositionofElementinSortedArray34M {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] ans = searchRange(nums,target);
        System.out.println(ans[0]+" "+ans[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        System.out.println(left+" "+right);
        if(left <= right && right < nums.length&&nums[left]==target&&nums[right]==target){
            return new int[]{left,right};
        }
        return new int[]{-1,-1};
    }

    public static int searchLeft(int[] nums, int target) {
        int left = 0,right=nums.length-1;
        while (left<=right) {
            int mid = left+(right-left)/2;
            if(nums[mid]>=target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
    

    public static int searchRight(int[] nums, int target) {
        int left = 0,right=nums.length-1;
        while (left<=right) {
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return right;
    }
}
