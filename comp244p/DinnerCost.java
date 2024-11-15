package comp244p;
public class DinnerCost {
    public static int minDinnerCost(int n, boolean[] freeMeals) {
        // 初始化 dp 数组，大小为 n + 7 防止越界
        int[] dp = new int[n + 8];
        
        // 从第 n+1 到 n+6 天都初始化为0，因为这些天不需要花费
        for (int i = n + 1; i <= n + 7; i++) {
            dp[i] = 0;
        }

        // 从最后一天向前计算最低花费
        for (int i = n; i >= 1; i--) {
            if (freeMeals[i - 1]) {
                dp[i] = dp[i + 1];  // 第 i 天有免费餐，花费为 dp[i + 1]
            } else {
                dp[i] = Math.min(6 + dp[i + 1], 20 + dp[i + 7]);  // 选择当天买一餐或买一周食材
            }
        }
        
        // 返回从第一天开始的最小花费
        return dp[1];
    }

    public static void main(String[] args) {
        int n = 10;  // 总天数
        boolean[] freeMeals = {false, true, false, false, true, false, false, false, true, false};  // 免费餐日程
        
        System.out.println("最低花费: $" + minDinnerCost(n, freeMeals));
    }
}

