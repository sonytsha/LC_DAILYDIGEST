class Solution {
    boolean cycle = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         boolean[] visited = new boolean[numCourses];
         boolean[] temp = new boolean[numCourses];
         int[] ans = new int[numCourses];
         Stack<Integer> stack = new Stack<>();

         for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                dfs(i, prerequisites, visited, temp, stack);
                if(cycle) return new int[0];
            }
         }

         for(int i=0;i<numCourses;i++){
            if(!visited[i]) return new int[0];
         }
         
         int i =numCourses-1;
         while(!stack.isEmpty()){
            int curr = stack.peek();
            ans[i--] = curr;
            stack.pop();
         }
         return ans;
    }
    public void dfs(int start, int[][] prerequisites, boolean[] visited, boolean[] temp, Stack<Integer> stack){
        visited[start] = true;
        temp[start] = true;
        for(int i=0;i<prerequisites.length;i++){
            int curr1 = prerequisites[i][0];
            int curr2 = prerequisites[i][1];
            if(curr1 == start){
                if(temp[curr2] == true){
                    cycle = true;
                    break;
                }
                if(!visited[curr2]){
                    dfs(curr2, prerequisites, visited, temp, stack);
                }
            }
        }
        stack.push(start);
        temp[start] = false;
    }
}