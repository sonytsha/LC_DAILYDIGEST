class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int len = s.length();
        for(int i=0;i<len;i++){
            char curr = s.charAt(i);
            if(curr == '('){
                stack.push(i);
            }
            else{
               stack.pop();
               if(stack.isEmpty()){
                stack.push(i);
               } 
               else{
                max = Math.max(max , i - stack.peek());
               }
            }
        }
        return max;
    }
}