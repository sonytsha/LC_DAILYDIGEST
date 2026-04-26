class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int len = nums.length;
        List<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);

        if(nums.length==1){
            return arr;
        }

        for(int i=1;i<len-1;i++){
            if(strictlyGreaterRightOrLeft(nums, i)){
                arr.add(nums[i]);
            }
        }
        arr.add(nums[len-1]);

        return arr;
    }
    public boolean strictlyGreaterRightOrLeft(int[] nums, int position){
        int len = nums.length;
        boolean greaterRight = true, greaterLeft = true;
        for(int i=0;i<position;i++){
            if(nums[i] >= nums[position]){
                greaterLeft = false;
            }
        }
        for(int i= position+1;i<len;i++){
            if(nums[i] >= nums[position]){
                greaterRight = false;
            }
        }
        return greaterLeft || greaterRight;
    }
}