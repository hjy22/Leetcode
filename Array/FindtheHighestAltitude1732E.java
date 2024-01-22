package Array;

import java.util.Arrays;

//https://leetcode.com/problems/find-the-highest-altitude/
public class FindtheHighestAltitude1732E {
    public static void main(String[] args) {
        int[] gain = { -5, 1, 5, 0, -7 };
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int[] array = new int[gain.length + 1];
        array[0] = 0;
        for (int i = 1; i < array.length; i++) {
            array[i]=array[i-1]+gain[i-1];
        }
        Arrays.sort(array);
        return array[array.length-1];
    }
}
