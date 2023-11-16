package Sort;

import java.util.*;

public class MaximumElementM1846 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 11, 11 };
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int length =  arr.length;
        Arrays.sort(arr);
        arr[0] = 1; 

        for (int i = 1; i < length; ++i) {
            if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                arr[i] = arr[i - 1] + 1; 
            }
        }

        return arr[length - 1]; 
    }
}
