class Solution {
    int pos = -1;
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        pos = -1;
        recursion(haystack , needle , 0, haystack.length()-1, "" , 0);
        return pos;
    }
    public void recursion(String haystack , String needle , int start, int end, String newString, int index){
        if (newString.length() == needle.length()) { 
            if(newString.equals(needle)) {
            pos = index;
        }
        return;
        }
        if(start > end) return;
        if(pos!= -1) return;
        if (haystack.charAt(start) != needle.charAt(newString.length())) {
        recursion(haystack, needle, index + 1, end, "", index + 1);
            return;
        }
        newString = newString + haystack.charAt(start);
        recursion(haystack , needle, start+1, end, newString, index);
        
    }
}