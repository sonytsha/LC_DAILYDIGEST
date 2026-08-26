class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, prod = 1;
        int store = n;
        while(n>0){
            int rem = n%10;
            sum += rem;
            prod = prod * rem;
            n = n/10;
        }
        //System.out.println("sum = " + sum);
        //System.out.println("prod = " + prod);
        return (store % (sum + prod) == 0);
    }
}