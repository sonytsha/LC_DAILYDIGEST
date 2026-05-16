class Solution {
    boolean cycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(cycle) return false;
        boolean[] visited = new boolean[numCourses];
        boolean[] temp = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                dfs(i, prerequisites , visited, temp);
                if(cycle) return false;
            }
        }
        for(int i=0;i<numCourses ;i++){
            if(!visited[i]) return false;
        }
        return true;
    }
    public void dfs(int start , int[][] prerequisites, boolean[] visited, boolean[] temp){
        if (cycle) return;
        visited[start] = true;
        temp[start] = true;

        for(int i=0;i<prerequisites.length;i++){
            int curr1 = prerequisites[i][0];
            int curr2 = prerequisites[i][1];
            if(curr1 == start){
                if(temp[curr2] == true) {
                    cycle = true;
                    return;
                }
                if(!visited[curr2]){
                dfs(curr2, prerequisites, visited, temp);
                }
            }
        }
        temp[start] = false;
    }
}