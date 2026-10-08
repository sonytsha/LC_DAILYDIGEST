class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recursion(nums, ans, 0);
        return ans;
    }
    public void swap(int start, int end, int[] nums){
        int hold = nums[start];
        nums[start] = nums[end];
        nums[end] = hold;
    }
    public void recursion(int[] nums, List<List<Integer>> ans, int index){
        if(index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index ;i< nums.length;i++){
            swap(i,index, nums);
            recursion(nums, ans, index+1);
            swap(i,index, nums);
        }
    }
}