class Solution {
    public int[] findDegrees(int[][] matrix) {
        int len = matrix.length;
        int[] ans = new int[len];
        for(int i=0;i<len;i++){
           for(int j=0;j<len;j++){
                if(matrix[i][j] == 1 && i!=j){
                    ans[i]++;
                    ans[j]++;
                }
           }
        }
        for(int i=0;i<len;i++){
            ans[i] = ans[i]/2;
        }
           return ans;
    }
}

/* 
  0 1 2
------------
0 | 0 1 1 
1 | 1 0 1
2 | 1 1 0
  | 
*/