class Solution {
    StringBuilder sb = new StringBuilder();
    public String removeDuplicates(String s) {
        sb = new StringBuilder(s);
        recursion(s,0,s.length()-1);
        return sb.toString();
    }
    public void recursion(String s, int start, int end){
        if(start + 1 >= sb.length()){
            return;
        }
        if(sb.charAt(start) == sb.charAt(start+1)){
            sb.deleteCharAt(start + 1);
            sb.deleteCharAt(start);
            if (start > 0) {
        recursion(s, start - 1, end);
        } else {
        recursion(s, start, end);
        }
        return;
        }
        recursion(s, start + 1, end);
}
}