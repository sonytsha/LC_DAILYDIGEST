class AuthenticationManager {
    HashMap<String, Integer> map = new HashMap<>();
    int ttl ;
    public AuthenticationManager(int timeToLive) {
        ttl = timeToLive;
        // for(Map.Entry<String,Integer> mp : map.entrySet()){
        //     int value = mp.getValue();
        //     String key = mp.getKey();
        //     map.put(key, value-timeToLive);
        // }
    }
    
    public void generate(String tokenId, int currentTime) {
        if(!map.containsKey(tokenId)){
            map.put(tokenId,currentTime+ttl);
        }
    }
    
    public void renew(String tokenId, int currentTime) {
        if(map.containsKey(tokenId) && map.get(tokenId) > currentTime){
            map.put(tokenId , currentTime+ttl);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for(Map.Entry<String, Integer> mp : map.entrySet()){
            if(mp.getValue() > currentTime){
                count++;
            }
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */