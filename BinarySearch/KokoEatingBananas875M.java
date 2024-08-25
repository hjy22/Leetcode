package BinarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBananas875M {
    public static void main(String[] args) {
        int[] piles = { 312884470};
        int h = 968709470;
        System.out.println(minEatingSpeed(piles,h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left=1,right = Arrays.stream(piles).max().getAsInt();
        while (left<right) {
            int mid=left+(right-left)/2;
            int hours= calculateSpeed(piles, mid);
            if(hours<=h){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    //计算如果速度为x，需要多少个小时完成
    public static int calculateSpeed(int[] piles, int x) {
        int hours = 0;
        for (int pile : piles) {
            //整数部分需要多少个小时
            hours += pile / x;
            //一堆里还剩一部分，需要再花一小时去完成
            if (pile % x > 0) {
                hours++;
            }
        }
        return hours;
    }
}
