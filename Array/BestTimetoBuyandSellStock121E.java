package Array;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimetoBuyandSellStock121E {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int min_buy = prices[0];
        int ans =0;
        for(int i=0;i<prices.length;i++){
            ans=Math.max(ans, prices[i]-min_buy);
            min_buy = Math.min(prices[i], min_buy);
        }
        return ans;
    }
}
