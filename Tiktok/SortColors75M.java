package Tiktok;

// https://leetcode.com/problems/sort-colors/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class SortColors75M {
    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        sortColorsBubble(nums);
        for (int i : nums) {
            System.out.print(i+" ");

        }
    }

    public static void sortColorsBubble(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1;j++){
                if(nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }
    }
}
