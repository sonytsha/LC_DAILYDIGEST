class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] store = new int[n+1];
        store[0] = 0;
        for(int i=1;i<=n;i++){
            store[i] = store[i-1] + gain[i-1];
        }

        int maxi = 0;
        for(int i=0;i<n+1;i++){
          //  System.out.println("Store[i] = " + store[i]);
            maxi = Math.max(maxi, store[i]);
        }

        return maxi;
    }
}