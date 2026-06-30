class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int size = ans.length();
            if (size >= 2 && ans.charAt(size - 1) == s.charAt(i) && ans.charAt(size - 2) == s.charAt(i)) {
                continue;
            }
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}