package Array;

import java.util.List;
import java.util.ArrayList;

//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
public class KidsWiththeGreatestNumberofCandies1431E {
    public static void main(String[] args) {
        int[] candies = { -1, 0, 3, 5, 9, 12 };
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int maxCandies = 0;
        for (int i : candies) {
            maxCandies = Math.max(i, maxCandies);
        }
        for (int i : candies) {
            if(i+extraCandies>=maxCandies){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }
}
