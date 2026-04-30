class Solution {
    public int maxProfit(int[] prices) {
        int maxi = 0;
        int buy = prices[0];
        for(int i=1;i<prices.length;i++){
            int sell = prices[i];
            if(sell > buy) {
                int profit = sell - buy;
                maxi = Math.max(profit, maxi);
            }
            else{
                buy = sell;
            }
        }
        return maxi;
    }
}