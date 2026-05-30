class Solution {
    public int beautySum(String s) {
        int count = 0;

        for(int i=0;i<s.length();i++){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j=i;j<s.length();j++){
                char val = s.charAt(j);
                if(map.containsKey(val)){
                    map.put(val, map.get(val)+1);
                }
                else{
                    map.put(val,1);
                }

            List<Integer> list = new ArrayList<>(map.values());
            Collections.sort(list);
            if(list.size()>=2) count += (list.get(list.size()-1) - list.get(0));
            }
        }
        return count;
    }
}