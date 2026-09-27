class Solution {
    public String reverseParentheses(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else if(ch == ')'){
                StringBuilder shortsb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '('){
                    shortsb.append(stack.peek());
                    stack.pop();
                }
                stack.pop(); // removing "("
               // System.out.println("shortsb " + shortsb);
                for(int j=0;j<shortsb.length();j++){
                    stack.push(shortsb.charAt(j));
                }
            }
            else{
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
                sb.append(stack.peek());
                stack.pop();
        }
        return sb.reverse().toString(); 
    }
}

// u e v o l i 