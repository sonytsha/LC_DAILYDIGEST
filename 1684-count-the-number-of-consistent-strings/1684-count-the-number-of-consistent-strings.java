class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for(int i=0;i<words.length;i++){
            String curr = words[i];
            int match = 0;
            int len1 = curr.length();
            for(int j=0;j<len1;j++){
                String curr1 = curr.charAt(j) + "";
                if(!allowed.contains(curr1)){
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
}
