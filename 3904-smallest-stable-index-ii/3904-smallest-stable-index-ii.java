class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int len = nums.length;
        int[] prefixMax = new int[len];
        prefixMax[0] = nums[0];
        for(int i=1;i<len;i++){
            prefixMax[i] = Math.max( prefixMax[i-1] , nums[i]) ;
        }
        // 5 5 6 9
        //10 5 5 4
        int[] suffixMin = new int[len];
        suffixMin[len-1] = nums[len-1];
        for(int i = len-2;i>=0;i--){
            suffixMin[i] = Math.min(suffixMin[i+1] , nums[i]);
        }
        // 3 5 6
        // 6 3 1 
        for(int i=0;i<len;i++){
            if(prefixMax[i] - suffixMin[i] <=k) return i;
        }
        return -1;
    }
}