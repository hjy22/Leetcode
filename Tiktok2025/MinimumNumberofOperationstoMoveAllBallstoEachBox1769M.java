package Tiktok2025;

// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class MinimumNumberofOperationstoMoveAllBallstoEachBox1769M {
    public static void main(String[] args) {
        String boxes = "110";
        int[] ans = minOperations(boxes);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    public static int[] minOperations(String boxes) {
        int length = boxes.length();
        int[] leftSum = new int[length], rightSum = new int[length];
        int leftCount = 0, rightCount = 0;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                leftSum[i] = leftSum[i - 1] + leftCount;
            }
            if (boxes.charAt(i) == '1') {
                leftCount++;
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1) {
                rightSum[i] = rightSum[i + 1] + rightCount;
            }
            if (boxes.charAt(i) == '1') {
                rightCount++;
            }
        }

        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = leftSum[i] + rightSum[i];
        }
        return ans;
    }
}
