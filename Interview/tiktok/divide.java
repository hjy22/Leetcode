package Interview.tiktok;


public class divide {
    private static int count = 0;

    public static void main(String[] args) {
        int[] nums = { 12, 18, 24, 36 };
        int k = 6;
        // int result = countSubsetsDivisibleByK(nums, k);
        int result = countSubsetsDivisibleByKDP(nums, k);
        System.out.println(result);
    }

    public static int countSubsetsDivisibleByK(int[] nums, int K) {
        count = 0;
        // 从数组第一个元素开始，逐步构建子集
        backtrack(nums, 0, 0, K);
        return count;
    }

    private static void backtrack(int[] nums, int index, int currentSum, int K) {
        // 如果已经处理完所有元素，检查当前和是否能被K整除
        if (index == nums.length) {
            if (currentSum != 0 && currentSum % K == 0) {
                count++;
            }
            return;
        }

        // 选择当前元素加入子集
        backtrack(nums, index + 1, currentSum + nums[index], K);

        // 不选择当前元素，跳过它
        backtrack(nums, index + 1, currentSum, K);
    }

    public static int countSubsetsDivisibleByKDP(int[] nums, int K) {
        // dp[i] 表示余数为 i 的子集数量
        int[] dp = new int[K];
        dp[0] = 1; // 初始情况，空集的和为 0

        // 遍历数组中的每个元素
        for (int num : nums) {
            int[] newDp = dp.clone(); // 用于更新 dp 数组，避免重复使用 num

            // 遍历当前的余数状态，从 0 到 K-1
            for (int i = 0; i < K; i++) {
                // 计算新余数，加入 num 后的余数 (注意处理负数情况)
                int newMod = (i + num % K + K) % K;
                newDp[newMod] += dp[i]; // 更新对应余数的子集个数
            }

            dp = newDp; // 更新 dp 数组
        }

        // 返回余数为 0 的子集数量，表示子集和能被 K 整除
        return dp[0] - 1; // 减去空集的情况
    }
}
