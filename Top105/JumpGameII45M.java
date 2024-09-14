package Top105;

// https://leetcode.com/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150
public class JumpGameII45M {
    public static void main(String[] args) {
        int[] nums = { 2,3,0,1,4 };
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int jumps = 0;  // 记录跳跃次数
        int farthest = 0;  // 当前能跳到的最远距离
        int end = 0;  // 当前跳跃的结束位置
        
        // 不需要遍历最后一个元素，因为到达终点前的跳跃已经包含了终点
        for (int i = 0; i < nums.length - 1; i++) {
            // 更新当前能跳到的最远距离
            farthest = Math.max(farthest, i + nums[i]);
            
            // 如果到达了当前跳跃的结束位置，需要进行一次跳跃
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }
        
        return jumps;
    }
}
