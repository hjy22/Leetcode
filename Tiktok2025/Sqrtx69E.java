package Tiktok2025;

// https://leetcode.com/problems/sqrtx/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class Sqrtx69E {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x / mid > mid) {
                left = mid + 1;
            } else if (x / mid < mid) {
                right = mid-1;
            }else{
                return mid;
            }
        }
        return right;
    }
}
