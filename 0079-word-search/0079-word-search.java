class Solution {
    int[] rowDirections = {0,0,1,-1};
    int[] columnDirections = {1,-1,0,0};

    public boolean exist(char[][] board, String word) {
        int totalRows = board.length;
        int totalColumns = board[0].length;

        for(int row = 0; row < totalRows; row++){
            for(int column = 0; column < totalColumns ; column++){
                if(dfs(board, word, row, column, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int currentRow, 
    int currentColumn, int index){
        if(index == word.length()) return true;

        int totalRows = board.length;
        int totalColumns = board[0].length;
        if(currentRow < 0 || currentRow >= totalRows || currentColumn < 0 
        || currentColumn >= totalColumns || board[currentRow][currentColumn] != word.charAt(index)){
            return false;
        }

        char temp = board[currentRow][currentColumn]; 
        board[currentRow][currentColumn] = '#'; // mark as visited

        for(int direction = 0; direction < 4; direction++){
            int newRow = currentRow + rowDirections[direction];
            int newColumn = currentColumn + columnDirections[direction];
            if(dfs(board, word, newRow, newColumn , index+1)){
                return true;
            }
        }
        board[currentRow][currentColumn] = temp; // backtrack
        return false;
    }
}