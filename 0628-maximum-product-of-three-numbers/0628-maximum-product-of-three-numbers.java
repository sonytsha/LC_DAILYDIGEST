class Solution {
    public int maximumProduct(int[] nums) {
        int top1 = Integer.MIN_VALUE, top2 = Integer.MIN_VALUE, top3 =Integer.MIN_VALUE;
        int bottom1 = Integer.MAX_VALUE , bottom2 = Integer.MAX_VALUE, bottom3 = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > top1){
                top3 = top2;
                top2 = top1;
                top1 = nums[i];
            }
            else if(nums[i] > top2){
                top3 = top2;
                top2 = nums[i];
            }
            else if(nums[i]> top3){
                top3 = nums[i];
            }
            if(nums[i] < bottom1){
                bottom3 = bottom2 ;
                bottom2 = bottom1;
                bottom1 = nums[i];
            }
            else if(nums[i] < bottom2){
                bottom3 = bottom2;
                bottom2 = nums[i];
            }
            else if(nums[i] < bottom3){
                bottom3 = nums[i];
            }
        }
        return Math.max(bottom1 * bottom2 * top1 , top1 * top2 * top3); 
    }
}