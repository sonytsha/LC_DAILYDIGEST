class NeighborSum {
    int[][] arr;

    public NeighborSum(int[][] grid) {
        arr = new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
        Arrays.fill(arr[i],-1);
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = grid[i][j];
            }
        }
    }
    
    public int adjacentSum(int value) {
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == value){
                    if(i > 0){
                        if(arr[i-1][j] != -1) sum += arr[i-1][j];
                    }
                    if(i<arr.length - 1){
                        if(arr[i+1][j] != -1) sum += arr[i+1][j];
                    }
                    if(j>0){
                        if(arr[i][j-1] != -1) sum += arr[i][j-1];
                    }
                    if(j<arr.length - 1){
                        if(arr[i][j+1] != -1) sum += arr[i][j+1];
                    }
                }
            }
        }
        return sum; 
    }
    
    public int diagonalSum(int value) {
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == value){
                    if(i>0 && j>0){
                        if(arr[i-1][j-1] != -1) sum += arr[i-1][j-1];
                    }
                    if(i< arr.length - 1 && j<arr.length - 1){
                        if(arr[i+1][j+1] != -1) sum += arr[i+1][j+1];
                    }
                    if(i> 0&& j<arr.length - 1){
                        if(arr[i-1][j+1] != -1) sum += arr[i-1][j+1] ;
                    }
                    if(i<arr.length - 1 && j>0){
                        if(arr[i+1][j-1] != -1) sum += arr[i+1][j-1];
                    }
                }
            }
        }
        return sum;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */