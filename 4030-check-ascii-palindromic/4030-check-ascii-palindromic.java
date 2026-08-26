class Solution {
    public boolean isPalindromic(String s) {
        String finalStr = "";
        int len = s.length();
        for(int i=0;i<len;i++){
            char curr = s.charAt(i);
            System.out.println("curr = " + curr);
            int AsciiValue = (int)curr;
            System.out.println("AsciiValue = " + AsciiValue);
            String str = Integer.toBinaryString(AsciiValue);
            System.out.println("str = " + str);
            if(str.length() < 8){
                int count = 8 - str.length();
                while(count>0){
                    str = '0' + str;
                    count--;
                }
            }
            finalStr += str;
            System.out.println("finalStr = " + finalStr);
        }
        return isPalindrome(finalStr);
    }
    public boolean isPalindrome(String s){
        int start = 0, end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            else{
                start++;
                end--;
            }
        }
        return true;
    }
}