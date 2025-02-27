package RoundOne2025;

// https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBananas875M {
    public static void main(String[] args) {
        int[] nums = { 3, 6, 7, 11 };
        int target = 8;
        System.out.println(minEatingSpeed(nums, target));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left=0,right=1000000001;
        while (left<=right) {
            int mid = (left+right)/2;
            if(calSpeed(piles, mid)<=h){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public static long calSpeed(int[] piles, int x) {
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / x;
            if (piles[i] % x > 0) {
                hours++;
            }
        }
        return hours;
    }
}
