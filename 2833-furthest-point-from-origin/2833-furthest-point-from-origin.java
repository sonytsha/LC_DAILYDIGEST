class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int countL= 0, countR = 0, countDash = 0;
        for(int i=0;i<moves.length();i++){
            char curr = moves.charAt(i);
            if(curr == 'L') countL++;
            else if(curr == 'R') countR++;
            else countDash++;
        }
        return Math.abs(countL - countR) + countDash;
    }
}