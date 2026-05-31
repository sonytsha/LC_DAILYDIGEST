class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i]) +1 );
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> b.getValue() - a.getValue());

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).getKey();
        }
        
        return ans;
    }
}