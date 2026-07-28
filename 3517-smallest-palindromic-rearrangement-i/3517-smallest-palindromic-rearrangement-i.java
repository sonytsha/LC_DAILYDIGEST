class Solution {
    public String smallestPalindrome(String s) {
        int len = s.length();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }
            else{
                map.put(ch, map.get(ch) + 1);
            }
        }

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        for(HashMap.Entry<Character, Integer> x : map.entrySet()){
            char key = x.getKey();
            int value = x.getValue();
            int half = value/2;
            for (int i = 0; i < half; i++) {
                left.append(key);
            }
            if (value % 2 == 1) {
                mid.append(key);
            }
        }

        right = new StringBuilder(left).reverse();
        StringBuilder ans = new StringBuilder();
        ans.append(left);
        ans.append(mid);
        ans.append(right);
        return ans.toString();

    }
}