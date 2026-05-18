class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] visited = new boolean[numCourses];

        boolean[] temp = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){

            if(!visited[i]){

                if(dfs(i, prerequisites, visited, temp)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int start,
                       int[][] prerequisites,
                       boolean[] visited,
                       boolean[] temp){

        visited[start] = true;

        temp[start] = true;

        for(int i = 0; i < prerequisites.length; i++){

            int curr1 = prerequisites[i][0];

            int curr2 = prerequisites[i][1];

            if(curr1 == start){

                if(temp[curr2]){
                    return true;
                }

                if(!visited[curr2]){

                    if(dfs(curr2,
                           prerequisites,
                           visited,
                           temp)){

                        return true;
                    }
                }
            }
        }

        temp[start] = false;

        return false;
    }
}