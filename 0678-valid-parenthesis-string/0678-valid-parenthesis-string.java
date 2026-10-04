class Solution {
    public boolean checkValidString(String s) {
        int star = 0, open = 0, close = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            char curr = s.charAt(i);
            if(curr == '('){
                open++;
            }
            else if(curr == '*'){
                star++;
            }
            else{
                if(open > 0){
                    open--;
                }
                else if(star > 0){
                    star--;
                }
                else{
                    System.out.println("hi here");
                    return false;
                }
            }
        }
        
        open = 0; close = 0; star = 0;
        for(int i=len-1;i>=0;i--){
            char curr = s.charAt(i);
            if(curr == ')'){
                close++;
            }
            else if(curr == '*'){
                star++;
            }
            else{
                if(close > 0){
                    close--;
                }
                else if(star > 0){
                    star--;
                }
                else{
                    System.out.println("hi here");
                    return false;
                }
            }
        }

        return true;
    }
}

/* 
"(****"
idex = 0 open++ open = 1
idex = 1 star++ star = 4 open = 1

*/