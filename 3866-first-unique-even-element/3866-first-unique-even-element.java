class Solution {
    public int firstUniqueEven(int[] nums) {
        int len = nums.length;
        int[] even = new int[10001];
        for(int i=0;i<len;i++){
            if(nums[i]%2==0){
                even[nums[i]]++;
            }
        }
        for(int i=0;i<len;i++){
            if(nums[i]%2 == 0 && even[nums[i]] ==1 ){
                return nums[i];
            }
        }

        return -1;
    }
}

/* 

why this didnt work coz suppose 3 times it repeated, so first time it added in set , second time it removed and third time it added back in set, so it means even with duplicate its in set

class Solution {
    public int firstUniqueEven(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new LinkedHashSet<>();
        for(int i=0;i<len;i++){
            if(nums[i] % 2 == 0){
                if(!set.isEmpty()){
                    if(!set.contains(nums[i])){
                        set.add(nums[i]);
                    }
                    else{
                        set.remove(nums[i]);
                    }
                }
                else{
                    set.add(nums[i]);
                }
            }
        }
        if(set.isEmpty()) return -1;
        Iterator<Integer> it = set.iterator();
        return it.next();
    }
}

*/