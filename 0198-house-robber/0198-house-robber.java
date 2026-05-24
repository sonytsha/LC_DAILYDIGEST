class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len==1) return nums[0];
        if(len==2) return Math.max(nums[0],nums[1]);
        int prev1 = nums[0];
        int prev2 = Math.max(nums[0],nums[1]);
        for(int i=2;i<len;i++){
            int current = Math.max(prev2 , prev1+nums[i]);
            prev1 = prev2;
            prev2 = current;
        }
        return prev2;
    }
}