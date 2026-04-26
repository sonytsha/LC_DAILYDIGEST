class Solution {
    int[] rowDirections = {0,0,1,-1};
    int[] columnDirections = {1,-1,0,0};

    public int numEnclaves(int[][] grid) {
        int totalRows = grid.length;
        int totalColumns = grid[0].length;

        for(int row = 0 ;row<totalRows;row++){
            if(grid[row][0] == 1) dfs(grid, row,0);
            if(grid[row][totalColumns-1] == 1) dfs(grid, row, totalColumns-1);
        }
        for(int column = 0; column < totalColumns; column++){
            if(grid[0][column] == 1) dfs(grid,0,column);
            if(grid[totalRows-1][column] ==1) dfs(grid, totalRows-1, column);
        }


        int count = 0;
        for(int row=0;row<totalRows ; row++){
            for(int column=0;column<totalColumns;column++){
                if(grid[row][column] == 1){
                    count++;
                }
            }
        }

        return count;
    }
    public void dfs(int[][] grid, int currentRow , int currentColumn){
        int totalRows = grid.length;
        int totalColumns = grid[0].length;
        if(currentRow < 0 || currentRow >= totalRows || currentColumn< 0|| 
        currentColumn >= totalColumns || grid[currentRow][currentColumn] ==0){
            return;
        }
        grid[currentRow][currentColumn] = 0;
        for(int direction = 0; direction < 4; direction++){
            int newRow = currentRow + rowDirections[direction];
            int newColumn = currentColumn + columnDirections[direction];
            dfs(grid,newRow,newColumn);
        }
    }
}