class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        recursion(nums, ans, new ArrayList<Integer>(), 0, nums.length-1);
        for (List<Integer> list : ans) {
            Collections.sort(list);
        }
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<ans.size();i++){
            List<Integer> arr = ans.get(i);
            if(!set.contains(arr)){
                set.add(arr);
            }
            else{
                ans.remove(i);
                i--;
            }
        }

        ans.sort((a, b) -> a.toString().compareTo(b.toString()));
        return ans;
    }
    public void recursion(int[] nums, List<List<Integer>> arr, List<Integer> sublist, int start, int end){
        ans.add(new ArrayList<>(sublist));
        if (start > end) {
            return;
        }
        recursion(nums, arr, sublist, start+1, end);
        sublist.add(nums[start]);
        recursion(nums, arr, sublist, start+1, end);   
        sublist.remove(sublist.size() - 1);
    }
}