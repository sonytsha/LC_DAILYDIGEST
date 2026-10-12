class Solution {
    boolean solved = false;
    public void solveSudoku(char[][] board) {
        isSolve(board);
    }
    // considering its always possible to solve this sodeku
    public void isSolve(char[][] board){
        if(solved) return;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    for(char c = '1' ;  c<= '9';c++){
                        if(isValid(board, i,j,c)){
                            board[i][j] = c;
                            isSolve(board);
                            if(solved) return;
                            board[i][j] = '.';
                        }
                    }
                    return;
                }
            }
        }
        solved = true; 
    }

    public boolean isValid(char[][] board, int row, int col, int c){
        for(int i=0;i<9;i++){
            if(board[row][i] == c) return false;
            if(board[i][col] == c) return false;
        }
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for(int i=startRow;i<startRow+3;i++){
            for(int j= startCol;j<startCol+3;j++){
                if(board[i][j] ==c) return false;
            }
        }
        return true;
    }
}