class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        long[][] pref = new long[n][n + 1];

        // 1. Column-wise Prefix Sums
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                pref[j][i + 1] = pref[j][i] + grid[i][j];
            }
        }

        // dp[h] = max score ending at current column with height h
        long[] inc = new long[n + 1];
        long[] dec = new long[n + 1];
        
        // Initial state for column 0
        for (int h = 0; h <= n; h++) {
            inc[h] = 0; 
            dec[h] = 0;
        }

        for (int j = 1; j < n; j++) {
            long[] nextInc = new long[n + 1];
            long[] nextDec = new long[n + 1];

            // Case A: Increasing (hPrev < hCurr)
            // We gain points from column j-1 in the range [hPrev, hCurr]
            long bestPrev = 0;
            for (int h = 0; h <= n; h++) {
                bestPrev = Math.max(bestPrev, inc[h] - pref[j - 1][h]);
                nextInc[h] = bestPrev + pref[j - 1][h];
            }

            // Case B: Decreasing (hPrev > hCurr)
            // We gain points from column j in the range [hCurr, hPrev]
            bestPrev = 0;
            for (int h = n; h >= 0; h--) {
                bestPrev = Math.max(bestPrev, Math.max(inc[h], dec[h]) + pref[j][h]);
                nextDec[h] = bestPrev - pref[j][h];
            }
            
            // Special Case: Transitions to h=0 (The "Reset")
            long maxAny = 0;
            for (int h = 0; h <= n; h++) maxAny = Math.max(maxAny, Math.max(inc[h], dec[h]));
            nextInc[0] = Math.max(nextInc[0], maxAny);

            inc = nextInc;
            dec = nextDec;
        }

        long ans = 0;
        for (int h = 0; h <= n; h++) ans = Math.max(ans, Math.max(inc[h], dec[h]));
        return ans;
    }
}