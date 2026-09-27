class Solution {
    private int index = 0;
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        while(index < s.length()){
            char c = s.charAt(index);
            index++;
            if(c == '('){
                String nestedResult = reverseParentheses(s);
                sb.append(nestedResult);

            }
            else if(c == ')'){
                return sb.reverse().toString();
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}