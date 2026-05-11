class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            ArrayList<Integer> subarr = new ArrayList<>();
            while(nums[i] > 0){
                int rem = nums[i]%10;
                subarr.add(rem);
                nums[i] = nums[i]/10;
            }
            Collections.reverse(subarr);
            for(int j=0;j<subarr.size();j++){
                arr.add(subarr.get(j));
            }
        }
        int[] ans = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            ans[i] = arr.get(i);
        }
        return ans;
    }
}