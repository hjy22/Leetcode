package Array;

//https://leetcode.com/problems/next-permutation/description/
public class NextPermutation31M {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 4, 2 };
        nextPermutation(nums);
        System.out.println();
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }

    public static void nextPermutation(int[] nums) {
        // 1. 找到第一个下降点
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

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
