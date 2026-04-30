class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            int sell = prices[i];
            if(buy > sell){
                buy = sell;
            }
            else{
                int profit = sell - buy;
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }
}