class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int maxProfit = Integer.MIN_VALUE;
        int buy = prices[0];
        for(int i=1;i<len;i++){
            int sell = prices[i];
            if(buy > sell){
                buy = sell;
            }
            else{
                int profit = sell- buy;
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }
}