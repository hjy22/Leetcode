package BinarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/heaters/
public class Heaters475M {
    public static void main(String[] args) {
        int[] houses = { 1, 2, 3 };
        int[] heaters = { 2 };

        System.out.println(findRadius(houses, heaters));
    }

    public static int findRadius(int[] houses, int[] heaters) {
        int maxRadius = 0;
        //heater顺序不对
        Arrays.sort(heaters);
        for (int house : houses) {
            maxRadius = Math.max(maxRadius, closestHouse(house, heaters));
        }
        return maxRadius;
    }

    public static int closestHouse(int house, int[] heaters) {
        int left = 0, right = heaters.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (house < heaters[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left == 0) {
            // 房屋在所有供暖器之前
            return Math.abs(heaters[0] - house);
        } else if (left == heaters.length) {
            // 房屋在所有供暖器之后
            return Math.abs(heaters[heaters.length - 1] - house);
        } else {
            // 房屋在中间，需要比较两个供暖器的位置，取最小的
            return Math.min(Math.abs(heaters[left] - house), Math.abs(heaters[left - 1] - house));
        }
    }
}
