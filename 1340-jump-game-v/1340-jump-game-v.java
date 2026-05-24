class Solution {
    public int maxJumps(int[] arr, int d) {
        int[] maxjumpsFrom = new int[arr.length];
        int maxi = 0;
        Arrays.fill(maxjumpsFrom, -1); // filling it with -1 as initially its all 0 
        for(int i=0;i<arr.length;i++){
            maxi = Math.max(maxi, dfs(arr,d,maxjumpsFrom,i));
        }
        return maxi;
    }


    public int dfs(int[] arr, int d, int[] maxjumpsFrom, int start){
        // base case : if already computed, return the cached value
        if(maxjumpsFrom[start] != -1){
            return maxjumpsFrom[start];
        }

        int maxJump = 1; // counting the current

        // left side movement
        for(int i = start-1 ;i>=0;i--){ // start-1 coz u dont jump on current index!
            if(i < start-d) break; // +d jump not possible
            if(arr[start] > arr[i]){
                maxJump = Math.max(maxJump, 1 + dfs(arr,d, maxjumpsFrom,i));
            }
            else{
                break;
            }
        }

        // right side movement
        for(int i = start+1;i<arr.length;i++){
            if(i > start+d) break;
            if(arr[start]> arr[i]){
                maxJump = Math.max(maxJump, 1+ dfs(arr,d,maxjumpsFrom,i));
            }
            else{
                break;
            }
        }
        maxjumpsFrom[start] = maxJump; // storing 
        return maxJump;
    }
}