class Solution {
    public int reverse(int x) {
        long reversed = 0;
        while(x!=0){
            int rem = x%10;
            reversed = reversed * 10 + rem;
            x = x/10;
        }
        if(reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) return 0;
        return (int)reversed;
    }
}
/* 123 
3 
3*10 + 2 = 32
32 *10 + 1 = 321
437474673437 
*/