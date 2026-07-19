class Solution {
    public String smallestSubsequence(String s) {
        int len = s.length();

        HashMap<Character, Integer> map= new HashMap<>();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }
            else{
                map.put(ch, map.get(ch)+1);
            }
        }

        Stack<Character> stack = new Stack<>();
        for(int i=0;i < len;i++){
            char ch = s.charAt(i);
            map.put(ch, map.get(ch) - 1);
            if(stack.contains(ch)) continue;

            while(!stack.isEmpty() && stack.peek() > ch 
            && map.get(stack.peek()) > 0){
                    stack.pop();
            }
            stack.push(ch);
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}