class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }
    public boolean dfs(int[] arr, int i , boolean[] visited){
        if(i<0 || i>= arr.length) return false;
        if(visited[i]) return false;
        if(arr[i] == 0) return true;
        visited[i] = true;
        int forward = i + arr[i];
        int reverse = i-arr[i];
        return dfs(arr,forward,visited) || dfs(arr, reverse, visited);
    }
}