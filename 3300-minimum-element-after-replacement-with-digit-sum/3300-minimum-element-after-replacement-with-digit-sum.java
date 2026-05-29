class Solution {
    public int minElement(int[] nums) {
        int len = nums.length;
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            nums[i] = digitSum(nums[i]);
            mini = Math.min(mini, nums[i]);
        }
        return mini == Integer.MAX_VALUE ? -1 : mini;
    }
    public int digitSum(int digit){
        int sum = 0;
        while(digit>0){
            int rem = digit%10;
            sum += rem;
            digit = digit/10;
        }
        return sum;
    }
}