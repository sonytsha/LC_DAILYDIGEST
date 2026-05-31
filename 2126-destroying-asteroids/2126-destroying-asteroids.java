class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int len = asteroids.length;
        long currentMass = mass; 
        for(int i=0;i<len;i++){
            if(asteroids[i] <= currentMass){
                currentMass = currentMass + asteroids[i];
            }
            else{
                return false;
            }
        }
        return true;
    }
}