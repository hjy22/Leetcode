package Array;

// https://leetcode.com/problems/find-the-score-of-all-prefixes-of-an-array
public class FindtheScoreofAllPrefixesofanArray2640M {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 7, 5, 10 };
        long[] ans = findPrefixScore(nums);
        for(long i:ans){
            System.out.print(i+" ");
        }
        
    }

    public static long[] findPrefixScore(int[] nums) {
        long[] ans = new long[nums.length];
        int max=nums[0];
        ans[0]=max+max;
        for(int i=1;i<nums.length;i++){
            max=Math.max(max, nums[i]);
            ans[i]=ans[i-1]+max+nums[i];
        }
        return ans;
    }
}
