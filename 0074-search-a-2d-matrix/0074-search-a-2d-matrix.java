class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0 ;
        int end = (row*col)-1; // flatten to 1d
        while(start <= end){
            int mid = (start+end)/2;
            // Formula to convert a 1D index back to [row][col] coordinates
            int curr = matrix[mid/col][mid%col];
            if(curr == target) return true;
            if(curr> target) end = mid -1;
            else start = mid+1;
        }
        return false;
    }
}