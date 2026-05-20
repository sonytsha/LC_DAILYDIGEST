class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[] rowcol = new int[2];
      //  int digit = Integer.MAX_VALUE;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int curr = mat[i][j];
                if ((i == 0 || curr > mat[i-1][j]) && 
                    (i == row - 1 || curr > mat[i+1][j]) && 
                    (j == 0 || curr > mat[i][j-1]) && 
                    (j == col - 1 || curr > mat[i][j+1])){
                    // System.out.println("getting in");
                    // System.out.println("rowcol[0] gi : " + rowcol[0]);
                    // System.out.println("rowcol[1] gi : " + rowcol[1]);
                    rowcol[0] = i;
                    rowcol[1] = j;
                   // digit = curr;
                }
            }
        }
    //     System.out.println("rowcol[0] : " + rowcol[0]);
    //     System.out.println("rowcol[1] : " + rowcol[1]);
    //     int[] ans = new int[2];
    //     for(int i=1;i<row-1;i++){
    //         for(int j=1;j<col-1;j++){
    //             int curr = mat[i][j];
    //             if(curr != -1){
    //                 rowcol[0] = i-rowcol[0];
    //                 rowcol[1] = j-rowcol[1];
    //                 System.out.println("rowcol[0] inside: " + rowcol[0]);
    //                 System.out.println("rowcol[1] inside: " + rowcol[1]);
    //             }   
    //         }
    //     } 
    //     return rowcol;
    // }
    return rowcol;
    }
}