class Solution {
    public int missingMultiple(int[] nums, int k) {
        int len = nums.length;
        int[] arr = new int[len];
        int j=1;
        for(int i=0;i<len;i++){
            arr[i] = k*j;
            j++;
        }
        for(int i=0;i<len;i++){
            int digit = arr[i];
            if(contains(nums, digit)){
                continue;
            }
            else{
                return digit;
            }
        }
        return k*j;
    }
    public boolean contains(int[] nums, int digit){
        for(int i=0;i<nums.length;i++){
            if(nums[i] == digit) return true;
        }
        return false;
    }
}