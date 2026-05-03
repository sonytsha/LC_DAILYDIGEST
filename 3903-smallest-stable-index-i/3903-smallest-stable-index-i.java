class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int len = nums.length;
        if(len==1) return 0;
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            int firsthalf = Integer.MIN_VALUE;
            for(int j=0;j<=i;j++){
                firsthalf  = Math.max(firsthalf, nums[j]);
                //System.out.println("firsthalf is :" + firsthalf);
            }
            int secondhalf = Integer.MAX_VALUE;
            for(int j= i;j<len;j++){
                secondhalf = Math.min(secondhalf, nums[j]);
                //System.out.println("secondhalf is :" + secondhalf);
            }
            if(firsthalf - secondhalf <= k){
                return i;
            }
        }
        return mini == Integer.MAX_VALUE ? -1 : mini;
    }
}