class Solution {
    public boolean uniformArray(int[] nums1) {
        int len = nums1.length;
        boolean allEven = true, allOdd = true;
        int evenC = 0, oddC = 0;
        for(int i=0;i<len;i++){
            if(nums1[i] % 2 == 0){
                allOdd = false;
                evenC++;
            }
            else{
                allEven = false;
                oddC++;
            }
        }
        if(allOdd || allEven) return true;
        if(evenC > 0 || oddC > 0) return true;

        return true;
        // anycase it will be true
        // [ 29, 22, 19] -> one even and 2 odd -> [29, -5, 19] all odd , true
        // [ 22, 33, 44] -> one odd -> [ -11, 33, 11] all odd, true

        // at the end everything will be odd and it will be true
    }
}