package Tiktok2025;

// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class MaximumPointsYouCanObtainfromCards1423M {
    public static void main(String[] args) {
        int[] cardPoints = { 96, 90, 41, 82, 39, 74, 64, 50, 30 };
        int k = 8;
        System.out.println(maxScore(cardPoints, k));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int totalSum = 0;
        for (int cardPoint : cardPoints) {
            totalSum += cardPoint;
        }
        if (k == cardPoints.length) {
            return totalSum;
        }

        int right = cardPoints.length - k, left = 0;
        int sum = 0;

        for (int i = 0; i < right; i++) {
            sum += cardPoints[i];
        }
        int minSum = sum;

        while (right<cardPoints.length) {
            sum+=cardPoints[right]-cardPoints[left];
            minSum = Math.min(minSum, sum);
            left++;
            right++;
        }

        return totalSum - minSum;
    }

}
