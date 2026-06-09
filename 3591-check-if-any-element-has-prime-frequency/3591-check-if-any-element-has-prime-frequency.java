class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
            else{
                map.put(nums[i] , map.get(nums[i])+1);
            }
        }
        
        for(int value : map.values()){
             if (isPrime(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPrime(int n){
        if(n==0 || n==1) return false;
        if(n==2) return true;
        for(int i=2;i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    
}