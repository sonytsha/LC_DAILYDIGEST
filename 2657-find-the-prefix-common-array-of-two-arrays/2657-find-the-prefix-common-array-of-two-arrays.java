class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len = A.length;
        int[] ans = new int[len];
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        if(A[0] == B[0]){
            ans[0] = 1;
            // System.out.println("i m adding in setA as commonfff " + A[0]);
            // System.out.println("i m adding in setB as commonfff " + B[0]);
        }
        setA.add(A[0]);
        setB.add(B[0]);

        for(int i=1;i<len;i++){
            ans[i] = ans[i - 1];
            if(A[i] == B[i]){
                 if (!setA.contains(A[i]) || !setB.contains(B[i])) {
                    ans[i]++;
                }
            }
            else{
                if(setA.contains(B[i])){
                    ans[i]++;  
                }
                if(setB.contains(A[i])){
                    ans[i]++;
                }
            }

            setA.add(A[i]);
            setB.add(B[i]);
        }
        return ans;
    }
}