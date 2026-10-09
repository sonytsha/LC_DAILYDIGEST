class Solution {
    int ans = 0;
    public int totalMoney(int n) {
        ans = 0;
        int start = 1;
        while(n>0){
            int days = Math.min(n, 7);
            recursion( days ,start);
            start++;
            n = n-7;
        }
        return ans;
    }
    public void recursion(int n, int start){
        if(n==0) return;
        ans += start;
        recursion(n-1, start+1);
    }
}