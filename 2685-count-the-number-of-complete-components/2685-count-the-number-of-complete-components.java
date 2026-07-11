class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            ArrayList<Integer> component = new ArrayList<>();
            if(visited[i] == false){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;

                while(!queue.isEmpty()){
                    int node = queue.poll();
                    component.add(node);
                    for(int j=0;j<adj.get(node).size();j++){
                        int neighbour = adj.get(node).get(j);
                        if(visited[neighbour] == false){
                            visited[neighbour] = true;
                            queue.add(neighbour);
                        }
                    }
                }

                boolean complete = true;
                for(int j=0;j<component.size();j++){
                    int node = component.get(j);
                    if(adj.get(node).size() != component.size()-1){
                        complete = false;
                        break;
                    }
                }
                if(complete) count++;
            }
        }
        return count;
    }
}