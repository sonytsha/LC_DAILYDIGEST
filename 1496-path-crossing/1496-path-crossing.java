class Solution {
    public boolean isPathCrossing(String path) {
        int len = path.length();
        int horizontal = 0 , vertical = 0;
        HashSet<String> set = new HashSet<>();
        set.add("0,0");
        for(int i=0;i<len;i++){
            char ch = path.charAt(i);
            if(ch == 'N') vertical++;
            else if(ch == 'S') vertical--;
            else if(ch == 'E') horizontal++;
            else horizontal--;
            String curr = horizontal + "," + vertical;
            if(set.contains(curr)) return true;
            set.add(curr);
        }
        return false;
    }
}