class Solution {

    private boolean isPalindrome(String s, int left, int right) {

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public String longestPalindrome(String s) {

        String ans = "";
        int maxi = 0;

        for(int start = 0; start < s.length(); start++) {

            int end = s.length() - 1;

            while(start <= end) {

                if(isPalindrome(s, start, end)) {

                    int len = end - start + 1;

                    if(len > maxi) {
                        ans = s.substring(start, end + 1);
                        maxi = len;
                        break;
                    }
                }

                end--;
            }
        }

        return ans;
    }
}