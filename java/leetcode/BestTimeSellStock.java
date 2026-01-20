public class BestTimeSellStock {
    public int maxProfit(int[] prices) {
        // int minPrice = Integer.MAX_VALUE;
        // int maxProfit=0;
        // for (int price: prices) {
        //     if (price<minPrice) {
        //         minPrice=price;
        //     } else {
        //         maxProfit=Math.max(price-minPrice, maxProfit);
        //     }
        // }
        // return maxProfit;
        int[][] dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i=1; i<prices.length;i++) {
            dp[i][0]=Math.max(dp[i-1][0], -prices[i]);
            dp[i][1]=Math.max(dp[i-1][0]+prices[i], dp[i-1][1]);
        }
        return dp[prices.length-1][0];
    }
}
