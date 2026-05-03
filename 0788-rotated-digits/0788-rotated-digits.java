class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i=0;i<=n;i++){
            String curr = Integer.toString(i);
            if(!curr.contains("3") && !curr.contains("4") && !curr.contains("7")){
                if(curr.contains("2") || curr.contains("5") || curr.contains("6") || curr.contains("9")){
                    count++;
                }
            }
        }
        return count;
    }
}

/* 
A number is valid after rotation if:

It does NOT contain invalid digits → 3,4,7
It contains at least one changing digit → 2,5,6,9
*/