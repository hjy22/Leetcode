package Top105;

// https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
public class JumpGame55M {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        //一直在更新能到达的最远的位置
        int lastJump = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i <= lastJump) {
                lastJump = Math.max(lastJump, i + nums[i]);
            }
        }
        return lastJump >= nums.length - 1;
    }
}
