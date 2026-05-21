class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len = rooms.size();
        // Input: rooms = [[1,3],[3,0,1],[2],[0]]
        boolean[] visited = new boolean[len];
        ArrayList<Integer> arr  = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        visited[0] = true;
        // marking 0 th pos as true, doesnt need keys
        queue.add(0);

        while(!queue.isEmpty()){
            int node = queue.poll();
            List<Integer> subarr = rooms.get(node);
            for(int i=0;i<subarr.size();i++){
                int keys = subarr.get(i);
                if(!visited[keys]){
                    queue.add(keys);
                    visited[keys] = true;
                    }                
                }
            }
        for(int i=0;i<visited.length;i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}