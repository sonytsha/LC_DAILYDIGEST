class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        int len = prices.length;
        int buy = prices[0];
        for(int i=1;i<len;i++){
            int sell = prices[i];
            if(sell > buy){
                int profit = sell - buy;
                total += profit;
                buy = sell;
            }
            else{
                buy = sell;
            }
        }
        return total;
    }
}

/* 1 2 3 4 6 */