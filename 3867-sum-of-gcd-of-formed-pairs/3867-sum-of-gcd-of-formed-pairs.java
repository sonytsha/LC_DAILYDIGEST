class Solution {
    public long gcdSum(int[] nums) {
        long sum = 0;
        int len = nums.length;
        int prefixGcd[] = new int[len];
        int max = nums[0];
        for(int i=0;i<len;i++){
            max = Math.max(max, nums[i]);
            // System.out.println("max " + max);
            prefixGcd[i] = gcd(max, nums[i]);
            // System.out.println("prefixGcd[i] :" + prefixGcd[i]);
        }
        Arrays.sort(prefixGcd);
        // System.out.println("after sorting ");
        // for(int i=0;i<len;i++){
        //     System.out.print(" prefixGcd[i] = " + prefixGcd[i]);
        // }
        int start = 0, end = len-1;
        while(start < end){
            int gcd = gcd(prefixGcd[start], prefixGcd[end]);
            sum += gcd;
            start++;
            end--;
        }
        return sum;
    }
    public int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}