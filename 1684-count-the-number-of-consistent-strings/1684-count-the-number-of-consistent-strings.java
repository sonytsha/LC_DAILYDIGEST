class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for(int i=0;i<words.length;i++){
            String curr = words[i];
            int match = 0;
            int len1 = curr.length();
            for(int j=0;j<len1;j++){
                char curr1 = curr.charAt(j);
                if(!isPresent(allowed, curr1)){
                    break;
                }
                else{
                    match++;
                }
            }
            if(match == len1) count++;
        }
        return count;
    }
    public boolean isPresent(String heh, char hm){
        for(int i=0;i<heh.length();i++){
            char ch = heh.charAt(i);
            if(ch == hm) return true;
        }
        return false;
    }
}