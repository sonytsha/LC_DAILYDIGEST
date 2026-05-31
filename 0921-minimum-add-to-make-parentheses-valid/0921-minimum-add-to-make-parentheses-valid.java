class Solution {
    public int minAddToMakeValid(String s) {
        int len = s.length();
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch== '('){
                stack.push(ch);
            }
            else{
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
                else{
                    count++;
                }
            }
        }
        return count+ stack.size();
    }
}