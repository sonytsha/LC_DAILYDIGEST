class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return faah(n,0);
    }
    public boolean faah(int n, int digit){
        if (n == 1) return true;
        if(n%2!=0) return false;
        return faah(n/2, digit-1);
    }
}