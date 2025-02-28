package RoundOne2025;

// https://leetcode.com/problems/car-pooling/
public class CarPooling1094M {
    public static void main(String[] args) {
        int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
        int n = 4;
        System.out.println(carPooling(trips, n));
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            int start = trip[1] ;
            int end = trip[2];
            int val = trip[0];

            diff[start] += val;
            if (end < 1000) {
                diff[end] -= val;
            }
        }
        int currentCapacity = 0;  
        for (int i = 0; i < 1001; i++) {
            currentCapacity += diff[i];  
            if (currentCapacity > capacity) { 
                return false;
            }
        }
        return true;
    }
}
