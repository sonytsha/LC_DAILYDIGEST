class Solution {
    public boolean isIsomorphic(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if(sLen != tLen) return false;
        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0;i<sLen;i++){
            char ch = s.charAt(i);
            char val = t.charAt(i);
            if(!map.containsKey(ch)){
                if(!map.containsValue(val)) map.put(ch, val);
                else return false;
            }
            else{
                if(map.get(ch) != val) return false;
            }
        }
        return true;
    }
}