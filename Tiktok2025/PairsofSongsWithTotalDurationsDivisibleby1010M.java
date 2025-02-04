package Tiktok2025;

// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class PairsofSongsWithTotalDurationsDivisibleby1010M {
    public static void main(String[] args) {
        int[] time = { 30, 20, 150, 100, 40 };
        System.out.println(numPairsDivisibleBy60(time));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int ans = 0;
        for (int t : time) {
            int reminder = t % 60;
            int pair = (60 - reminder) % 60;
            ans+=count[pair];
            count[reminder]++;
        }
        return ans;
    }
}
