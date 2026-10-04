class Solution {
    public void reverseString(char[] s) {
        recursion(s, 0, s.length-1);
    }
    public void recursion(char[] s , int start, int end){
        if(start > end) return;

        char swap = s[start];
        s[start] = s[end];
        s[end] = swap;
        recursion(s, start+1, end-1);
    }
}