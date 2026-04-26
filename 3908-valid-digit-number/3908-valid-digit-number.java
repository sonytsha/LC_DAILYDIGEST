class Solution {
    public boolean validDigit(int n, int x) {
        boolean find = false;
        while(n>=10){
            int rem = n%10;
            if(rem == x) find= true;
            n = n/10;
        }
        // System.out.println(n);
        if(n%10 == x) return false;
        return find;
    }
}