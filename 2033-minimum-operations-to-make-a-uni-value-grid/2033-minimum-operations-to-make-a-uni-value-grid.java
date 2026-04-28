class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> arr = new ArrayList<>();
        int base = grid[0][0];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if ((grid[i][j] - base) % x != 0) return -1;
                arr.add(grid[i][j]);
            }
        }
        Collections.sort(arr);
        int median = arr.get(arr.size()/2);
        int operation = 0;
        for(int i=0;i<arr.size();i++){
            operation += Math.abs(arr.get(i) - median)/ x;
        }
        return operation;
    }
}
