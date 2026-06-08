class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> lesser = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();
        int equal = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i] > pivot){
                greater.add(nums[i]);
            }
            else if(nums[i] < pivot){
                lesser.add(nums[i]);
            }
            else{
                equal++;
            }
        }

        for(int i=0;i<lesser.size();i++){
            nums[i] = lesser.get(i);
        }
        int j = lesser.size();
        while(equal > 0){
            nums[j] = pivot;
            j++;
            equal--;
        }

        for(int i=0;i<greater.size();i++){
            nums[j++] = greater.get(i);
        }
        return nums;
    }
}