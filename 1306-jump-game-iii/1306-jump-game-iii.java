class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            if(arr[node] == 0) return true;

            int right = node + arr[node];
            int left = node - arr[node];

            if(right < arr.length && !visited[right]){
                visited[right] = true;
                queue.add(right);
            }

            if(left >= 0 && !visited[left]){
                visited[left] = true;
                queue.add(left);
            }

        }
        return false;
    }
}