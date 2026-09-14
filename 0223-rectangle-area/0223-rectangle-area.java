class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int first = (ax2-ax1) *(ay2-ay1);
        int second = (bx2-bx1) *(by2-by1);

        int left = Math.max(ax1,bx1);
        int right = Math.min(ax2,bx2);
        int down = Math.max(ay1,by1);
        int up = Math.min(ay2,by2);

        int common = 0;
        if(left < right && down < up){
            common = (right-left) * ( up - down);
        }
        return first + second-common;
    }
}