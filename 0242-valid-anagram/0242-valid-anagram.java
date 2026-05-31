class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sHold = new int[26];
        int[] tHold = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            sHold[ch-'a']++;
        }


        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            tHold[ch-'a']++;
        }

        for(int i=0;i<26;i++){
            if(sHold[i] != tHold[i]) return false;
        }

        return true;
    }
}