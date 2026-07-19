class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            int sum = digitSum(i);
            if(!map.containsKey(sum)){
                map.put(sum, 1);
            }
            else{
                map.put(sum , map.get(sum) + 1);
            }
        }

        int maxi = 0;
        for(Map.Entry<Integer, Integer> mp : map.entrySet()){
            int value = mp.getValue();
            maxi = Math.max(maxi, value);
        }

        int count = 0;
        for(Map.Entry<Integer, Integer> mp : map.entrySet()){
            int value = mp.getValue();
            if(value == maxi) count++;
        }

        return count;
    }
    public int digitSum(int num){
        int sum = 0;
        while(num>0){
            sum += (num%10);
            num = num/10;
        }
        return sum;
    }
}

