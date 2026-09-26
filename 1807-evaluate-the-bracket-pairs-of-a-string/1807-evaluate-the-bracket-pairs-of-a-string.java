class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for(int i=0;i<knowledge.size();i++){
            String a = knowledge.get(i).get(0);
            String b = knowledge.get(i).get(1);
            map.put(a,b);
        }

        StringBuilder dup = new StringBuilder(); 
        String sb = "";
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                while(i < s.length() && s.charAt(i) != ')'){
                    sb += s.charAt(i);
                    i++;
                }
                sb += ')';
            }
            
            if(!sb.isEmpty()){
                String rawKey = sb.substring(1, sb.length()-1);
        String replacement = map.containsKey(rawKey) ? map.get(rawKey) : "?";
                dup.append(replacement); 
            } else {
                dup.append(ch); 
            }
            sb = "";
        }
        return dup.toString();
    }
}
