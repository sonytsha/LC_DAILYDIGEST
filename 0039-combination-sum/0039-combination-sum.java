class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        recursion(candidates, new ArrayList<>(), target, 0, 
        candidates.length-1);
        return ans;
    }
    public void recursion(int[] candidates, List<Integer> sublist, int target, int start, int end){
        if(target ==0){
            ans.add(new ArrayList<>(sublist));
            return;
        }
        if(start > end || target < 0 ) return;
        recursion(candidates, sublist, target, start+1, end);
        sublist.add(candidates[start]);
        recursion(candidates, sublist, target - candidates[start], start, end);
        sublist.remove(sublist.size()-1);
    }
}