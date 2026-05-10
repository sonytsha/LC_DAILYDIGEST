class Solution {
    public int findKthPositive(int[] arr, int k) {
        ArrayList<Integer> store = new ArrayList<>();
        int count = 0;
        for(int i=1;i<=2000 && count <= k;i++){
            if(!contains(arr,i)){
                store.add(i);
                count++;
                if(count == k) return store.get(store.size()-1);
            }
        }
        return -1;
    }
    public boolean contains(int[] arr, int digit){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == digit){
                return true;
            }
        }
        return false;
    }
}