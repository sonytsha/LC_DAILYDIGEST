class Solution {
    public int maxRotateFunction(int[] nums) {
        int len = nums.length;
        long sum = 0;
        long digit = 0;
        for(int i=0;i<len;i++){
            sum += nums[i];
            digit += (long)i* nums[i];
        }
        long maxi = digit;
        for(int i=1;i<len;i++){
            digit = digit + sum - (long)len * nums[len - i];
            maxi = Math.max(maxi, digit);
        }
        return (int)maxi;
    }
    public void rotate(int[] nums, int k){
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
    }
    public void reverse(int[] nums, int start, int end){
        int len = nums.length;
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}