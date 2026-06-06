class Solution {
    public int[] leftRightDifference(int[] nums) {
        int len = nums.length;
        int[] leftSum = new int[len];
        int[] rightSum = new int[len]; 
        leftSum[0] = nums[0];
        for(int i=1;i<len;i++){
            leftSum[i] = leftSum[i-1] + nums[i];
           // System.out.println("left sum is : " + leftSum[i]);
        }  
        rightSum[len-1] = nums[len-1];
        for(int i=len-2;i>=0;i--){
            rightSum[i] = rightSum[i+1]+nums[i];
           // System.out.println("right sum is : " + rightSum[i]);
        }

        for(int i=0;i<len;i++){
            nums[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return nums;
    }
}