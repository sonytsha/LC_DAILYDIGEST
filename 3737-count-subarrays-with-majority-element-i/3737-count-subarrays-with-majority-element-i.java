class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int len = nums.length;
        int ans = 0;
        for(int i=0;i<len;i++){
            ArrayList<Integer> arr = new ArrayList<>();
            int count = 0;
            for(int j=i;j<len;j++){
                arr.add(nums[j]);
                if(nums[j] == target) count++;
                if(count > arr.size()/2) ans++;
            }
        }
        return ans;
    }
}