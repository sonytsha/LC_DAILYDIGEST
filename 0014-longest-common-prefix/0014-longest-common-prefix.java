class Solution {
    public String longestCommonPrefix(String[] strs) {
        List<String> res = new ArrayList<>();
        String str0 = strs[0];
        for(int i = 0; i < str0.length(); i++){
            res.add(str0.substring(0, i + 1));
        }

        String ans = "";
        for(int i=0;i<res.size();i++){
            String curr = res.get(i);
            if(curr.length() > ans.length()){
                boolean contains = true;
                for(int j=1;j<strs.length;j++){
                    if(!strs[j].startsWith(curr)){
                        contains = false;
                        break;
                    }
                }
                if(contains){
                    ans = curr;
                }
            }
        }
        return ans;
    }
}