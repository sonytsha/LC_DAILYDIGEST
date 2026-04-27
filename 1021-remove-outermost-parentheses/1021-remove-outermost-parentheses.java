class Solution {
    public String removeOuterParentheses(String s) {
        String ans = "";
        int len = s.length();
        int open = 0;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(open > 0){
                    ans += ch;
                }
                open++;
            }
            else{
                open--;
                if(open >0){
                    ans += ch;
                }
            }
        }
        return ans;
    }
}