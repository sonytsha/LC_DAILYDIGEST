class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> sublist = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        sublist = new ArrayList<>();
        recursion(nums, 0, nums.length-1, ans, sublist);
        return ans;
    }
    public void recursion(int[] nums, int start , int end, List<List<Integer>> ans, List<Integer> sublist){
        if(start > end) {
            ans.add(new ArrayList<>(sublist));
            return;
        }
        recursion(nums, start+1, end, ans, sublist);
        sublist.add(nums[start]);
        recursion(nums, start+1, end, ans, sublist);
        sublist.remove(sublist.size() - 1);
    }
}