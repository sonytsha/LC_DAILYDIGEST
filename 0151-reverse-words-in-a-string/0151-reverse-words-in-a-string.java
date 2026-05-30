class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int len = s.length();
        String ans = "";
        String substring = "";
        for(int i = len-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch == ' '){
                if(!substring.equals("")){
                substring = substring.trim();
                System.out.println("substring 1 " + substring);
                ans = ans + substring;
                System.out.println("ans is " + ans);
                ans = ans + " ";
                substring = "";
                }
            }
            else{
                substring = ch + substring;
                System.out.println("subs 2 " + substring);
            }
        }
                System.out.println("substring 1 " + substring);
                ans = ans + substring;
        return ans;
    }
}