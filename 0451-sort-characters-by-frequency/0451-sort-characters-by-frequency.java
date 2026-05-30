class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                map.put(curr, map.get(curr)+1);
            }
            else{
                map.put(curr, 1);
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> b.getValue() - a.getValue());

        String ans = "";
        for(int i=0;i<list.size();i++){
            char ch = list.get(i).getKey();
            int freq = list.get(i).getValue();
            while(freq-->0){
                ans += ch;
            }
        }

        return ans;
    }
}