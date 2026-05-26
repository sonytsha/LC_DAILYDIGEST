class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for(int i=0;i<word.length();i++){
            char curr = word.charAt(i);
            if(!set.contains(Character.toUpperCase(curr))){
                if(word.contains(String.valueOf(Character.toUpperCase(curr))) && word.contains(String.valueOf(Character.toLowerCase(curr)))){
                    set.add(Character.toUpperCase(curr));
                    count++;
                }
            }
        }
        return count;
    }
}