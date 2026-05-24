class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Linear array tracking only a single row's cumulative step cost
        int[] dp = new int[n];
        
        // Base Case: Origin point initialization
        dp[0] = grid[0][0];
        
        // Fill the baseline top row (Row 0) -> can only move right
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        
        // Stream through the remaining rows from index 1 down to m - 1
        for (int i = 1; i < m; i++) {
            // Update the very first column of the new row (can only come from ABOVE)
            dp[0] = dp[0] + grid[i][0];
            
            // Process the internal cells
            for (int j = 1; j < n; j++) {
                // dp[j] (before overwrite) is the cost from ABOVE
                // dp[j-1] is the newly updated cost from the LEFT
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }
        
        return dp[n - 1];
    }
}


/*
1.

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j!= 0 ) dp[0][j] = grid[i][j] + dp[0][j-1];
                if(j==0 && i!= 0) dp[i][0] = grid[i][j] + dp[i-1][0];
                else if(i!=0 && j!=0) dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}

2. 

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j=1;j<n;j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}*/