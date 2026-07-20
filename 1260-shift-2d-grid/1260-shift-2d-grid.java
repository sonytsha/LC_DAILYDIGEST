class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans1 = new ArrayList<>();

        while(k>0){
           grid = move(grid);
            k--;
        }
        for (int i = 0; i < grid.length; i++) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int j = 0; j < grid[0].length; j++) {
            temp.add(grid[i][j]);
        }
        ans1.add(temp);
        }
        return ans1;
    }

    public int[][] move(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (j != n - 1) ans[i][j + 1] = grid[i][j];
                else if (i != m - 1) ans[i + 1][0] = grid[i][j];
                else ans[0][0] = grid[i][j];
            }
        }
        return ans;
    }
}