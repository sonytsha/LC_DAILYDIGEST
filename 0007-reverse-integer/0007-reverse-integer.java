class Solution {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        StringBuilder rev1 = sb.reverse();
        String rev = rev1.toString();
        String ans = "";
        if (rev.charAt(rev.length()-1) == '-') {
            ans += '-';
            ans = ans + rev.substring(0,rev.length()-1);
        }
        else ans = ans + rev.substring(0,rev.length());
        long store = Long.parseLong(ans);
        if(store >Integer.MAX_VALUE  || store < Integer.MIN_VALUE ) return 0;
        return (int)store;
    }
}