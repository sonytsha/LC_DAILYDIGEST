class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        int everyrow = 0;
        while(numRows > 0){
            everyrow++;
            List<Integer> sublist = new ArrayList<>();
            if(everyrow == 1){
                sublist.add(1);
            }
            else{
                List<Integer> prev = ans.get(everyrow-2);
                for(int i=0;i<everyrow;i++){
                    if(i==0 || i == everyrow-1){
                        sublist.add(1);
                    }
                    else{
                        sublist.add(prev.get(i-1) + prev.get(i));
                    }
                }
            }
                ans.add(sublist);
                numRows--;
        }
        return ans;
    }
}