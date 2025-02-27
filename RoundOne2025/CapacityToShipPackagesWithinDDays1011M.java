package RoundOne2025;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
public class CapacityToShipPackagesWithinDDays1011M {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 8;
        System.out.println(shipWithinDays(nums, target));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int left = weights[0], right = 0;
        for (int weight : weights) {
            left = Math.max(weight, left);
            right += weight;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (calSpeed(weights, mid) <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int calSpeed(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length;) {
            int capSum = x;
            while (i<weights.length&&capSum - weights[i] >= 0) {
                capSum -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }
}
