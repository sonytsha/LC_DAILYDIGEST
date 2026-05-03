class Solution {
    public int firstUniqueEven(int[] nums) {
        int len = nums.length;
        int[] even = new int[10001];
        for(int i=0;i<len;i++){
            if(nums[i]%2==0){
                even[nums[i]]++;
            }
        }
        for(int i=0;i<len;i++){
            if(nums[i]%2 == 0 && even[nums[i]] ==1 ){
                return nums[i];
            }
        }

        return -1;
    }
}