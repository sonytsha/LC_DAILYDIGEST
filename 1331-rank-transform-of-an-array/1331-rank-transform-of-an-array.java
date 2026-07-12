class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        int[] ans = new int[len];
        int[] arr1 = Arrays.copyOf(arr, len);
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr1);
        int rank = 1;
        for(int i=0;i<len;i++){
            if(!map.containsKey(arr1[i])) {
                map.put(arr1[i],rank);
                rank++;
            }
        }
        for(int i=0;i<len;i++){
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}