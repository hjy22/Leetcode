package Tiktok2025;

// https://leetcode.com/problems/kth-missing-positive-number/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class KthMissingPositiveNumber1539E {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 7, 11 };
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }

    public static int findKthPositive(int[] arr, int k) {
        int start = 1;
        int index = 0;
        while (k > 0) {
            if (index >= arr.length || arr[index] != start) {
                k--;
            } else {
                index++;
            }
            if (k == 0) {
                return start;
            }
            start++;
        }

        return start;
    }
}
