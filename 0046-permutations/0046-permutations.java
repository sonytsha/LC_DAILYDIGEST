class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recursion(nums, new ArrayList<>(), ans, freq);
        return ans;
    }
    public void recursion(int[] nums, List<Integer> list, List<List<Integer>> ans, boolean[] freq){
        if(list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(freq[i] != true){
                freq[i] = true;
                list.add(nums[i]);
                recursion(nums, list, ans, freq);
                freq[i] = false;
                list.remove(list.size()-1);
            }
        }
        
    }
}