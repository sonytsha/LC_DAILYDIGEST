class Solution {
    public void reverseString(char[] s) {
        revu(s,0, s.length-1);
    }
    public void revu(char[] s, int i , int n){
        if(i >= n) return;
        char first = s[i];
        s[i] = s[n];
        s[n] = first;
        revu(s,i+1,n-1);
    }
}