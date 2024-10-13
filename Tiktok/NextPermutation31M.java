package Tiktok;

// https://leetcode.com/problems/next-permutation/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class NextPermutation31M {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }

    public static void nextPermutation(int[] nums) {
        // 1. 从右往左找到第一个下降点
        int downPoint = -1;
        int back = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            int cur = nums[i];
            if (cur < back) {
                downPoint = i;
                break;
            }
            back = cur;
        }
        // 如果全升序，直接反转数组
        if (downPoint == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // 2.从右向左找到比 nums[i] 大的最小元素
        int min=nums[downPoint];
        int secondMin = Integer.MAX_VALUE;
        int secondIndex = -1;
        for(int i=nums.length-1;i>downPoint;i--){
            if(nums[i]>min){
                if(nums[i]<secondMin){
                    secondIndex = i;
                    secondMin = nums[i];
                }
            }
        }
        // 3.交换 nums[i] 和 nums[j]
        swap(nums, downPoint, secondIndex);
        // 4.反转 i 之后的部分
        reverse(nums, downPoint+1, nums.length-1);
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public static void reverse(int[] nums, int i, int j) {
        while (i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

}
