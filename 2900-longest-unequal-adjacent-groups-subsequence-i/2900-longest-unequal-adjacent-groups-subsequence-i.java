class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int len = words.length;
        ans.add(words[0]);
        int lastGroup = groups[0];
        for(int i=1;i<len;i++){
            if(groups[i] != lastGroup){
                ans.add(words[i]);
                lastGroup = groups[i];
            }
        }
        return ans;
    }
}

/* 0 1 0 1
0 0 1 1 

0 1 1 1 0
0 1 0 0 0 1 1 

*/

