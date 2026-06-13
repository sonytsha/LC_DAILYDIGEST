class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int len = words.length;
        int[] hold = new int[len];
        for(int i=0;i<len;i++){
            int count = 0;
            String curr = words[i];
          //  System.out.println(" for curr " + curr);
            for(int j=0;j<curr.length();j++){
                char curr1 = curr.charAt(j);
               // System.out.println("curr1 " + curr1);
                count += weights[curr1-'a'];
               // System.out.println("count " + count);
            }
            hold[i] = (count % 26);
           // System.out.println("hold[i] is " + i + " " + hold[i]);
        }

        String ans = "";
        for(int i=0;i<len;i++){
            char ch = (char) ('z' - hold[i]);
           // System.out.println("ch is " + ch);

            ans += ch;
           // System.out.println("ans is " + ans);
        }
        return ans;
    }
}