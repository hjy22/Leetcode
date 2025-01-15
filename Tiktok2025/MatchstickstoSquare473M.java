package Tiktok2025;

import java.util.Arrays;

// https://leetcode.com/problems/matchsticks-to-square/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class MatchstickstoSquare473M {
    public static void main(String[] args) {
        int[] matchsticks = { 5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3 };
        System.out.println(makesquare(matchsticks));
    }

    public static boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        int target = sum / 4;

        if (sum % 4 != 0) {
            return false;
        }
        return backTrack(matchsticks, new int[4], target, 0);
    }

    public static void reverse(int[] num) {
        int left = 0, right = num.length - 1;
        while (left <= right) {
            int tmp = num[left];
            num[left] = num[right];
            num[right] = tmp;
            left++;
            right--;
        }
    }

    public static boolean backTrack(int[] matchsticks, int[] sides, int target, int index) {
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }

        for (int i = 0; i < sides.length; i++) {
            if (sides[i] + matchsticks[index] > target) {
                continue;
            }
            sides[i] += matchsticks[index];
            if (backTrack(matchsticks, sides, target, index + 1)) {
                return true;
            }
            sides[i] -= matchsticks[index];
        }

        return false;
    }
}
