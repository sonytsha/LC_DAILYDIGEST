class Solution {
    public int minimumCost(int[] cost) {
        if(cost.length==1) return cost[0];
        if(cost.length ==2) return cost[0] + cost[1];
        Arrays.sort(cost);
        int totalCost = 0;
        int i = cost.length;
        while(i>=2){
            totalCost += (cost[i-1] + cost[i-2]);
            i = i-3;
        }
        if(i==1) totalCost += cost[i-1];
        return totalCost;
    }
}

/* 

6,5,7,9,2,2

2,2,5,6,7,9

*/