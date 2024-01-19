package Array;

//https://leetcode.com/problems/shuffle-the-array/
public class ShuffletheArray1470E {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 1, 3, 4, 7 };
        int n = 3;
        int[] ans = shuffle(nums, n);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < nums.length; i++) {
            if(i<n){
                ans[2*i]=nums[i];
            }else{
                ans[(i-n)*2+1]=nums[i];
            }
        }
        return ans;
    }
}
