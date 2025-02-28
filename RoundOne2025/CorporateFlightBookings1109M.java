package RoundOne2025;

//https://leetcode.com/problems/corporate-flight-bookings/description/
public class CorporateFlightBookings1109M {
    public static void main(String[] args) {
        int[][] bookings = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 2 } };
        int n = 5;
        int[] ans = corpFlightBookings(bookings, n);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 1];

        for (int[] booking : bookings) {
            int first = booking[0] - 1;
            int last = booking[1];
            int val = booking[2];

            diff[first] += val;
            if (last < n) {
                diff[last] -= val;
            }
        }

        int[] ans = new int[n];
        ans[0] = diff[0];
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] + diff[i];
        }
        return ans;
    }
}
