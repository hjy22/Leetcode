package Top105;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150
public class BestTimetoBuyandSellStock121E {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int ans =0;
        int minPrice = prices[0];
        for(int price:prices){
            minPrice=Math.min(minPrice, price);
            ans = Math.max(ans, price-minPrice);
        }
        return ans;
    }
}
