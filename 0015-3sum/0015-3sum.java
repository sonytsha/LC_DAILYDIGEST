class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        Set<String> set = new HashSet<>();
        Arrays.sort(nums); // for binary search
        for(int i=0;i<len-2;i++){
            for(int j=i+1;j<len-1;j++){
                int find = (nums[i] + nums[j]) * (-1);
                int indx = Arrays.binarySearch(nums, j+1, len, find);
                if(indx >= 0){
                        List<Integer> sublist = new ArrayList<>();
                        sublist.add(nums[i]);
                        sublist.add(nums[j]);
                        sublist.add(nums[indx]);
                        Collections.sort(sublist);
                        String newString =
                                sublist.get(0) + "," +
                                sublist.get(1) + "," +
                                sublist.get(2);

                        if(!set.contains(newString)){
                            set.add(newString);
                            list.add(sublist);
                        }
                        else{
                            continue;
                            }
                        }
                    }
                }
        return list;
    }
}