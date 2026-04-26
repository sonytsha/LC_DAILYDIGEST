class Solution {
    int[] rowDirections = {0,0,1,-1};
    int[] columnDirections = {1,-1,0,0};

    public void solve(char[][] board) {
        int totalRows = board.length;
        int totalColumns = board[0].length;

        // left and right
        for(int row = 0; row< totalRows;row++){
            if(board[row][0] == 'O') dfs(board,row,0);
            if(board[row][totalColumns-1] == 'O') dfs(board, row, totalColumns-1);
        }

        // top and bottom rows
        for(int column = 0; column < totalColumns;column++){
            if(board[0][column] == 'O') dfs(board, 0, column);
            if(board[totalRows-1][column] == 'O') dfs(board, totalRows-1, column);
        }

        for(int row = 0; row < totalRows ;row++){
            for(int column = 0; column < totalColumns ; column++){
                if(board[row][column] == 'O'){
                    board[row][column] = 'X';
                }
                else if(board[row][column] == 'T'){
                    board[row][column] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int currentRow, int currentColumn){
        int totalRows = board.length;
        int totalColumns = board[0].length;

        if(currentRow < 0 || currentColumn < 0 || currentRow >= totalRows 
        || currentColumn >= totalColumns || board[currentRow][currentColumn] != 'O'){
            return;
        }
        board[currentRow][currentColumn] = 'T';

        for(int direction = 0; direction <4;direction++){
            int nextRow = currentRow + rowDirections[direction];
            int nextColumn = currentColumn + columnDirections[direction];
            dfs(board, nextRow, nextColumn);
        }

    }
}

/* 

Step 1: Boundary 'O' → mark 'T' (safe)
Step 2: Remaining 'O' → trapped → flip to 'X'
Step 3: 'T' → restore to 'O'

*/