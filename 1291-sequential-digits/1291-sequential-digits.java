class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String str = "123456789";
        int lowLen = Integer.toString(low).length();
        int highLen = Integer.toString(high).length();
        //System.out.println("lowLen" + lowLen);
      //  System.out.println("highLen" + highLen);

        int var = highLen - lowLen;
        //System.out.println("var" + var);
        while(var > 0){
        for(int i=0;i<= str.length() - lowLen;i++){
            String substr = str.substring(i,i+lowLen);
           // System.out.println("substr" + substr);
            int x = Integer.parseInt(substr);
            if(x <= high && x>= low) ans.add(x);
            }
            lowLen++;
        var--;
        }

        for(int i=0;i<=str.length() - highLen;i++){
            String substr = str.substring(i,i+highLen);
           // System.out.println("substr1 : " + substr);
            int x = Integer.parseInt(substr);
            if(x <= high && x>= low) ans.add(x);
        }

        return ans;
    }
}



/*
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for(int i= low ;i<=high ;i++){
            if(valid(i)){
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean valid(int digit){
        String str = Integer.toString(digit);
        for(int i=1;i<str.length();i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            if (curr != (char)(prev + 1)) {
                return false;
            }
        }
        return true;
    }
}

*/