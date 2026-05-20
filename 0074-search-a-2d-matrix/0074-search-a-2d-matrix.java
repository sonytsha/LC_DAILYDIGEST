class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length - 1; // Start at top-right corner
        
        while (r < matrix.length && c >= 0) {
            int curr = matrix[r][c];
            if (curr == target) {
                return true;
            } else if (curr > target) {
                c--; // Target is smaller, eliminate this entire column (move left)
            } else {
                r++; // Target is larger, eliminate this entire row (move down)
            }
        }
        return false;
    }
}