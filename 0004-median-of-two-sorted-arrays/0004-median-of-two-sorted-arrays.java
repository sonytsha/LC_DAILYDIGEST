class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m+n];
        for(int i=0;i<m;i++){
            ans[i] = nums1[i];
        }
        int j = m;
        for(int i= 0;i<n;i++){
            ans[j] = nums2[i];
            j++;
        }
        for(int i=0;i<m+n;i++){
            System.out.println(ans[i] +  " ");
        }
        Arrays.sort(ans);
        System.out.println(ans[(m+n)/2]);
        if((m+n)%2 != 0) return (double)ans[(m+n)/2];
        return ((double) ans[(m+n)/2] + (double) ans[(m+n)/2 - 1]) / 2;
    }
}