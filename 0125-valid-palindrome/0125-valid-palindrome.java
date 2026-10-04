class Solution {
    boolean palindrome = true;
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if((curr >= 'a' && curr <= 'z') || (curr >= 'A' && curr <= 'Z')){
                sb.append(Character.toLowerCase(curr));
            }
            if(curr >= '0' && curr <= '9'){
                sb.append(curr);
            }
        }
        recursion(sb, 0 , sb.length()-1);
        return palindrome;
    }
    public void recursion(StringBuilder sb , int start, int end){
        if(start > end){
            return;
        }
        if(sb.charAt(start) != sb.charAt(end)){
            palindrome = false;
            return;
        }
        recursion(sb, start+1, end-1);
    }
}