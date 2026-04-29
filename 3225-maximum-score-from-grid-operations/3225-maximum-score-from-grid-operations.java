class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        
            /* . Why prefixSum[col][row] instead of [row][col]?
            In Java, a 2D array is actually an "array of arrays."

            If we use prefixSum[col][row], then prefixSum[col] points to a single contiguous block 
            of memory containing all the prefix sums for that specific column.

            When the CPU accesses prefixSum[col][row] and then prefixSum[col][row+1], it stays 
            within the same memory block (Cache Hit), which is significantly faster.

            Since our DP moves column by column, it is much cleaner to say: "Give me the sum of 
            Column 5" by accessing prefixSum[5].
            */
            
        /* * QUESTION 1: Why prefixSum[col][row + 1]?
         * Answer: We use (row + 1) to handle the base case where height is 0. 
         * prefixSum[col][0] = 0 (sum of zero cells).
         * prefixSum[col][5] = sum of cells from row 0 to 4.
         * This prevents 'IndexOutOfBounds' and makes calculating ranges (High - Low) easier.
         */
        long[][] prefixSum = new long[n][n + 1];
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                prefixSum[col][row + 1] = prefixSum[col][row] + grid[row][col];
            }
        }

        /* * QUESTION 2: How does the prefix table look?
         * If Column 0 is [0, 0, 0, 5, 0], prefixSum[0] looks like:
         * [0, 0, 0, 0, 5, 5]  <-- Index 0 is always 0. Index 4 is the sum of first 4 rows.
         */

        /* * QUESTION 3: What are 'increasing' and 'decreasing' arrays?
         * Increasing (inc): Max score if current column is TALLER than the previous.
         * Decreasing (dec): Max score if current column is SHORTER than the previous.
         * We separate them to avoid "double-counting" the same cells.
         */
        long[] inc = new long[n + 1];
        long[] dec = new long[n + 1];

        // QUESTION 4: Why fill with 0? 
        // Because at column 0, we haven't built anything yet, so our score is 0.
        // In Java, long arrays are 0 by default, but we treat this as our "Base Case."

        // QUESTION 5: Why start from col = 1?
        // A column needs a neighbor to be "exposed." Column 0 can only be scored 
        // once we know the height of Column 1.
        for (int col = 1; col < n; col++) {
            long[] nextInc = new long[n + 1];
            long[] nextDec = new long[n + 1];

            // --- CASE 1: THE RISE (hPrev < hCurr) ---
            // We gain points from the PREVIOUS column (col-1) because the current
            // height hCurr "exposes" the cells in col-1.
            long bestShiftedValue = -1; 
            for (int hCurr = 0; hCurr <= n; hCurr++) {
                // We optimize O(N^3) to O(N^2) by tracking the best (inc[hPrev] - prefixSum[col-1][hPrev])
                bestShiftedValue = Math.max(bestShiftedValue, inc[hCurr] - prefixSum[col - 1][hCurr]);
                nextInc[hCurr] = bestShiftedValue + prefixSum[col - 1][hCurr];
            }

            // --- CASE 2: THE FALL (hPrev > hCurr) ---
            // We gain points from the CURRENT column (col) because the previous
            // height hPrev was taller, "exposing" cells in our current column.
            bestShiftedValue = -1;
            for (int hCurr = n; hCurr >= 0; hCurr--) {
                // When falling, we can transition from either an increasing or decreasing state.
                long currentMaxState = Math.max(inc[hCurr], dec[hCurr]);
                bestShiftedValue = Math.max(bestShiftedValue, currentMaxState + prefixSum[col][hCurr]);
                nextDec[hCurr] = bestShiftedValue - prefixSum[col][hCurr];
            }
            
            /* * QUESTION 6: What is the special case (Reset)?
             * If we set hCurr = 0, we can transition from ANY previous state.
             * This effectively "finishes" a mountain and starts a new one.
             */
            long maxScoreAnywhere = 0;
            for (int h = 0; h <= n; h++) {
                maxScoreAnywhere = Math.max(maxScoreAnywhere, Math.max(inc[h], dec[h]));
            }
            nextInc[0] = Math.max(nextInc[0], maxScoreAnywhere);

            // Move to the next column
            inc = nextInc;
            dec = nextDec;
        }

        // Final result is the maximum value in either state after the last column
        long finalAnswer = 0;
        for (int h = 0; h <= n; h++) {
            finalAnswer = Math.max(finalAnswer, Math.max(inc[h], dec[h]));
        }
        return finalAnswer;
    }
}