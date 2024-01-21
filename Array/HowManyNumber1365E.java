package Array;

//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/submissions=
public class HowManyNumber1365E {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        System.out.println(smallerNumbersThanCurrent(nums));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i==j){
                    continue;
                }
                if(nums[i]>nums[j]){
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
