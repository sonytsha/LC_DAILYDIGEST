class Solution {
    int[] rowDirections = {0,0,1,-1};
    int[] columnDirections = {1,-1,0,0};

    public int numIslands(char[][] grid) {
        int totalRows = grid.length;
        int totalColumns = grid[0].length;
        int count = 0;
        for(int row = 0; row < totalRows ; row++){
            for(int column = 0; column < totalColumns ; column++){
                if(grid[row][column] == '1'){
                    count++;
                    dfs(grid, row , column);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int currentRow, int currentColumns){

        if(currentRow < 0 || currentRow >= grid.length || currentColumns < 0 
        || currentColumns >= grid[0].length || grid[currentRow][currentColumns] == '0'){
            return;
        }
        // mark visited
        grid[currentRow][currentColumns] = '0';

        for(int directions = 0; directions < 4; directions++){
            int nextRow = currentRow + rowDirections[directions];
            int nextColumn = currentColumns + columnDirections[directions];
            dfs(grid, nextRow, nextColumn);
        }
    }
}