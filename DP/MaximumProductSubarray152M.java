package DP;

//https://leetcode.com/problems/maximum-product-subarray
public class MaximumProductSubarray152M {
    public static void main(String[] args) {
        int[] nums = { -2,3,-4 };
        System.out.println(maxProduct(nums));
    }

    //维护两个dp数组，最大值和最小值
    //最小值*负数就是最大值了
    //用double存，int会丢失精度
    public static int maxProduct(int[] nums) {
        double maxProduct = nums[0];  // 使用double类型来计算
        double[] maxDP = new double[nums.length];
        double[] minDP = new double[nums.length];
        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            double prevMax = maxDP[i-1]; // 先保存之前的maxDP[i-1]
            maxDP[i] = max(prevMax * nums[i], minDP[i-1] * nums[i], nums[i]);
            minDP[i] = min(prevMax * nums[i], minDP[i-1] * nums[i], nums[i]);
            maxProduct = Math.max(maxProduct, maxDP[i]);
        }

        return (int)maxProduct;  // 最终将结果转换为int返回
    }

    public static double max(double a,double b,double c){
        return Math.max(Math.max(a, b),c);
    }
    public static double min(double a,double b,double c){
        return Math.min(Math.min(a, b),c);
    }
}
