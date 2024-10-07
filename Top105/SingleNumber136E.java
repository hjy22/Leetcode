package Top105;

// https://leetcode.com/problems/single-number/?envType=study-plan-v2&envId=top-interview-150
public class SingleNumber136E {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 1 };
        System.out.println(singleNumber(nums));
    }

    /*
     * 使用异或的方法
     * a^a=0
     * 遍历数组，每个元素都异或
     * 得出的结果就是那个无重复的
     */
    public static int singleNumber(int[] nums) {
        int n = 0;
        for (int i : nums) {
            n ^= i;
        }
        return n;
    }
}
