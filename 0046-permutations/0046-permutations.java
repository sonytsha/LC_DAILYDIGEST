class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        recursion(nums, new ArrayList<>(), ans, 0);
        return ans;
    }
    public void swap(int start, int end, int[] nums){
        int hold = nums[start];
        nums[start] = nums[end];
        nums[end] = hold;
    }
    public void recursion(int[] nums, List<Integer> list, List<List<Integer>> ans, int index){
        if(list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index ;i< nums.length;i++){
            swap(i,index, nums);
            list.add(nums[index]);
            recursion(nums,list, ans, index+1);
            list.remove(list.size()-1);
            swap(i,index, nums);

        }
    }
}