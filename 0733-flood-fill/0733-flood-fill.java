class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if (image[sr][sc] == color) return image;
            int originalColor = image[sr][sc];
            boolean[][] visited = new boolean[image.length][image[0].length];
            dfs(image, sr, sc, color, visited,originalColor);
            return image;
    }

    public void dfs(int[][] image, int i, int j, int color, boolean[][] visited ,int originalColor){
        image[i][j] = color;
        visited[i][j] = true;

        for(int sr=0;sr<image.length;sr++){
            for(int sc=0;sc<image[0].length;sc++){
                if(sr==0){
                    if(sc == 0){
                        if (sr + 1 < image.length) visited[sr+1][sc] = true;
                        if (sc + 1 < image[0].length) visited[sr][sc+1] = true;
                        visited[sr][sc] = true;
                    }
                    else{
                        if(sc!= image[0].length-1){
                            if (sc + 1 < image[0].length) visited[sr][sc+1] = true;
                            if (sc - 1 >= 0) visited[sr][sc-1] = true;
                            // FIXED: Added boundary check for row (sr + 1) and column (sc + 1)
                            if (sr + 1 < image.length && sc + 1 < image[0].length) visited[sr+1][sc+1] = true;
                        }
                        else{
                            if (sc - 1 >= 0) visited[sr][sc-1] = true;
                            // FIXED: Added boundary check for row (sr + 1)
                            if (sr + 1 < image.length) visited[sr+1][sc] = true;
                        }
                    }
                }
                
                if(sc == 0){
                    if(sr!=0){
                        if(sr != image.length-1){
                            if (sr + 1 < image.length) visited[sr+1][sc] = true;
                            if (sr - 1 >= 0) visited[sr-1][sc] = true;
                            // FIXED: Added boundary check for row (sr + 1) and column (sc + 1)
                            if (sr + 1 < image.length && sc + 1 < image[0].length) visited[sr+1][sc+1] = true;
                        }
                        else{
                            if (sr - 1 >= 0) visited[sr-1][sc] = true;
                            if (sc + 1 < image[0].length) visited[sr][sc+1] = true;
                        }
                    }
                }

                else{
                    if (sr > 0 && sc > 0 && sr < image.length - 1 && sc < image[0].length - 1) {
                        visited[sr+1][sc+1] = true;
                        visited[sr][sc+1] = true;
                        visited[sr-1][sc] = true;
                        visited[sr][sc-1] = true;
                        visited[sr+1][sc] = true;
                    }
                }
                boolean isNeighbor = (Math.abs(sr - i) == 1 && sc == j) || (Math.abs(sc - j) == 1 && sr == i);
                // If it's an immediate neighbor, your loops marked it true, and it matches the color pool, JUMP!
                if (isNeighbor && visited[sr][sc] && image[sr][sc] == originalColor && image[sr][sc] != color) {
                    dfs(image, sr, sc, color, visited, originalColor);
                }
            } 
        }
    }
}