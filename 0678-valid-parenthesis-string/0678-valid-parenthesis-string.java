class Solution {
    public boolean checkValidString(String s) {
        int len = s.length();
        int openorstar = 0;
        for(int i=0;i<len;i++){
            char curr = s.charAt(i);
            if(curr == '(' || curr == '*'){
                openorstar++;
            }
            else{
                openorstar--;
            }
            if(openorstar<0){
                return false;
            }
        }

        int closeorstar = 0;
        for(int i=len-1;i>=0;i--){
            char curr = s.charAt(i);
            if(curr == ')' || curr == '*'){
                closeorstar++;
            }
            else{
                closeorstar--;
            }
            if(closeorstar <0){
                return false;
            }
        }

        return true;

    }
}