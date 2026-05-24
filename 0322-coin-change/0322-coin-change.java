class Solution {
    public int coinChange(int[] coins, int amount) {
        // unbounded knapsack
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                int currentCoin = coins[j];
                if(i-currentCoin >=0){
                    dp[i] = Math.min(dp[i], 1+ dp[i-currentCoin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}