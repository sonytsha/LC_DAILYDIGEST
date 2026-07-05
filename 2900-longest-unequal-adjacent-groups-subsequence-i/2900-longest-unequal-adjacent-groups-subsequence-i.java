class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int len = words.length;
        ans.add(words[0]);
        for(int i=1;i<len;i++){
            int prev = groups[i-1];
            int curr = groups[i];
            if(prev!=curr){
                ans.add(words[i]);
                prev++; curr++;
            }
            else{
                continue;
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