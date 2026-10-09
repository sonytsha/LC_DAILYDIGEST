class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        int count = 0;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else{
                if (i + 1 < len && s.charAt(i + 1) == ')') {
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    else{
                        count++;
                    }
                    i++;
                }
                else{
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    else{
                        count++;
                    }
                    count++;
                }
            }
        }
        
        while(!stack.isEmpty()){
            stack.pop();
            count = count+2;
        }
        return count;
    }
}