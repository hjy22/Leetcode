package Labuladong.SliceWindows;

//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
public class MaximumPointsYouCanObtainfromCards1423M {
    public static void main(String[] args) {
        int[] cardPoints = { 1,2,3,4,5,6,1 };
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }

    // 转化成找n-k和最小的subArray
    public static int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int sum = sum(cardPoints, 0, n);
        System.out.println(sum);
        int left = 0, right = n - k;
        int minSubSum = sum(cardPoints, left, right);
        while (right <= n) {
            int tmp = sum(cardPoints,left,right);
            minSubSum = Math.min(tmp, minSubSum);
            right++;
            left++;
        }
        return sum-minSubSum;
    }

    public static int sum(int[] cardPoints, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += cardPoints[i];
        }
        return sum;
    }
}
