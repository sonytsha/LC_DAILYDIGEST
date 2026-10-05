class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            char curr = s.charAt(i);
            if(curr == '('){
                stack.push(curr);
            }
            else{
                stack.pop();
                if(s.charAt(i-1)== '('){
                    score += Math.pow(2,stack.size());
                    
                }
            }
        }
        return score;
    }
}