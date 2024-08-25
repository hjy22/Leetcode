package Array;

// https://leetcode.com/problems/increasing-triplet-subsequence/
public class IncreasingTripletSubsequence334M {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1,3};
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        int a=Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for(int num:nums){
            if(a>num){
                a=num;
            }else if(b>num){
                b=num;
            }else{
                return true;
            }
        }
        return false;
    }
}
