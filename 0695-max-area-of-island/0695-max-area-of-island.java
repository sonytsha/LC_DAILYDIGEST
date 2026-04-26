class Solution {
    int[] rowDirections = {0,0,1,-1};
    int[] columnDirections = {1,-1,0,0};
    public int maxAreaOfIsland(int[][] grid) {
        int totalRows = grid.length;
        int totalColumns = grid[0].length;
        int maxi = 0;
        for(int row = 0; row < totalRows; row++){
            for(int column = 0; column < totalColumns ; column++){
                if(grid[row][column] == 1){
                    int area = dfs(grid, row, column);
                    maxi = Math.max(maxi, area);
                }
            }
        }
        return maxi;
    }
    public int dfs(int[][] grid, int currentRow, int currentColumn){
        int count = 1;
        int totalRows = grid.length;
        int totalColumns = grid[0].length;

        if(currentRow < 0 || currentRow >= totalRows || currentColumn < 0 
        || currentColumn >= totalColumns || grid[currentRow][currentColumn] == 0){
            return 0;
        }

        grid[currentRow][currentColumn] = 0;

        for(int directions = 0; directions < 4 ; directions++){
            int nextRow = currentRow + rowDirections[directions];
            int nextColumn = currentColumn + columnDirections[directions];
            count += dfs(grid, nextRow, nextColumn);
        }
        return count;
    }
}