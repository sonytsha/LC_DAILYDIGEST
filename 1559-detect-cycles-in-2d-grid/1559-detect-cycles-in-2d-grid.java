class Solution {
    int[] rowDirections = {0,0,1,-1};
    int[] columnDirections = {1,-1,0,0};

    public boolean containsCycle(char[][] grid) {
        int totalRows = grid.length;
        int totalColumns = grid[0].length;

        boolean[][] visited = new boolean[totalRows][totalColumns];

        for(int row=0;row<totalRows;row++){
            for(int col=0 ; col<totalColumns;col++){
                if(!visited[row][col]){
                    if(dfs(grid , visited, row, col, -1,-1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] grid , boolean[][] visited , int currentRow, 
    int currentColumn, int parentRow, int parentColumn){
        visited[currentRow][currentColumn] = true;

        int totalRow = grid.length;
        int totalColumn = grid[0].length;

        for(int direction = 0; direction < 4; direction++){
            int nextRow = currentRow + rowDirections[direction];
            int nextColumn = currentColumn + columnDirections[direction];

            // checkinh boundary
            if(nextRow < 0 || nextColumn < 0 || nextRow >= totalRow || 
            nextColumn >= totalColumn){
                continue;
            }
            // move only same
            if(grid[nextRow][nextColumn] != grid[currentRow][currentColumn]){
                continue;
            }

            if(!visited[nextRow][nextColumn]){
                if(dfs(grid, visited, nextRow , nextColumn, currentRow , currentColumn)){
                    return true;
                }
            }
            // already visited AND not coming from parent → cycle
            else if(nextRow != parentRow || nextColumn != parentColumn){
                return true;
            }
        }
        return false;
    }
}