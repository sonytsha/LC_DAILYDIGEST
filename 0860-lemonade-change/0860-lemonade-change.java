class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0, len = bills.length;
        for(int i=0;i<len;i++){
            if(bills[i] == 5){
                five++;
            }
            else if(bills[i] == 10){
                if(five>=1){
                    five--;
                    ten++;
                }
                else{
                    System.out.println("returning from 10");
                    return false;
                }
            }
            else{
                System.out.println("5 is " + five);
                System.out.println("10 is " + ten);

                if((ten>=1 && five >= 1)){
                    ten--;
                    five--;
                    System.out.println("am i entering 1?");
                }
                else if(five>=3){
                    five = five-3;
                    System.out.println("am i entering 2?");
                }
                else{
                    System.out.println("returning from 20");
                    return false;
                }
            }
        }
        return true;
    }
}