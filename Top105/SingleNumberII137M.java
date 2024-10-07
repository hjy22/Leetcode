package Top105;

// https://leetcode.com/problems/single-number-ii/description/?envType=study-plan-v2&envId=top-interview-150x
public class SingleNumberII137M {
    public static void main(String[] args) {
        int[] nums = { 2, 2,2,0,0,0, 1 };
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}
