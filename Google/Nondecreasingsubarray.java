package Google;

public class Nondecreasingsubarray {
    public static void main(String[] args) {
        int[] nums = { 0, 7, 3, 10, 2, 4, 6, 8, 0, 9, -20, 4 };
        System.out.println(findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {
        int maxLen = 1, curLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else {
                curLen = 1;
            }
        }
        return maxLen;
    }

}
