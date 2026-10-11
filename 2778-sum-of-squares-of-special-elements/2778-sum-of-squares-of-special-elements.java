class Solution {
    public int sumOfSquares(int[] nums) {
        int len = nums.length;
        int count = 0;
        for(int i=1;i<=len;i++){
            if(len%i == 0){
                count += (nums[i-1] * nums[i-1]);
            }
        }
        return count;
    }
}