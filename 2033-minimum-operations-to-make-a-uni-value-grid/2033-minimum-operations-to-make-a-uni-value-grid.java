class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if((grid[i][j] - grid[0][0]) %x != 0) return -1;
                arr.add(grid[i][j]);
            }
        }
        Collections.sort(arr);
        int median = (arr.get(arr.size()/2));
        int count = 0;
        for(int i=0;i<arr.size();i++){
            count+= Math.abs(arr.get(i) - median) / x;
        }
        return count;
    }
}

/* 2 5 
   6 8

   x = 2
*/

/* 2 4 
   6 8

   6

x = 2
2-> 4-> 6 -- 2 step
4 -> 6 -- 1 step
6 -> 6 -> 0 step
8 -> 6 ->> 1 step

*/