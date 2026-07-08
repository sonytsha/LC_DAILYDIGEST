class Solution {
    public int convertTime(String current, String correct) {
        int hour1 = (current.charAt(0) - '0') * 10 + (current.charAt(1) - '0');
        int hour2 = (correct.charAt(0) - '0') * 10 + (correct.charAt(1) - '0');
        int min1 = (current.charAt(3) - '0') * 10 + (current.charAt(4) - '0');
        int min2 = (correct.charAt(3) - '0') * 10 + (correct.charAt(4) - '0');
        if((hour1 * 60 + min1) - (hour2 * 60 + min2) == 0) return 0;
        if(hour2 == 0) hour2 = 24;
        int curr = hour1 * 60 + min1;
        int corr = hour2 * 60 + min2;
        int diff = corr - curr;
     //   System.out.println("diff is : " + diff);
        int count = 0;
        while(diff>0){
            if(diff>=60){
                diff -= 60;
                count++;
            }
            else if(diff >= 15){
                diff -= 15;
                count++;
            }
            else if(diff >=5){
                diff -= 5;
                count++;
            }
            else if(diff >=1){
                count++;
                diff -=1;
            }
        }
        return count;
    }
}