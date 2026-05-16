class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[len];
        boolean[] temp = new boolean[len];
        boolean[] cycle = new boolean[len];
        for(int i=0;i<len;i++){
            if(!visited[i]){
                dfs(i, graph, visited, temp, cycle);
            }
        }
        for (int i = 0; i < len; i++) {
            if (!cycle[i]) {
                list.add(i);
            }
        }
        return list;
    }

    // checking cycle exists or not here
    public boolean dfs(int start, int[][] graph, boolean[] visited, boolean[] temp, boolean[] cycle){
        visited[start] = true;
        temp[start] = true;
        for(int i=0;i<graph[start].length;i++){
            int next = graph[start][i];
                if(temp[next]){
                    cycle[start] = true;
                    return true; 
                }
                if(!visited[next]){
                   if(dfs(next, graph, visited, temp, cycle)){
                    cycle[start] = true;
                    return true;
                   }
                }
                else if (cycle[next]) {
                    cycle[start] = true;
                    return true;
                }
            }
        temp[start] = false;
        return false;
    }
}