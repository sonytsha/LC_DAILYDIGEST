class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        List<String>list = new ArrayList<>();
        List<Character> sublist = new ArrayList<>();
        for(int i=0;i< brokenLetters.length();i++){
            char ch = brokenLetters.charAt(i);
            sublist.add(ch);
        }
        for(int i=0;i<text.length();i++){
            StringBuilder sb = new StringBuilder();
            while(i < text.length() && text.charAt(i) != ' '){
                char ch = text.charAt(i);
                sb.append(ch);
                i++;
            }
            boolean found = false;
            for(int j=0;j<sb.length();j++){
                if(sublist.contains(sb.charAt(j))){
                    found = true;
                    break;
                }
            }
            if(found) continue;
            else{
                count++;
                found = false;
            }
        }
        return count;
    }
}