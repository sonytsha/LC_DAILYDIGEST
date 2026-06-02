class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            for(int j=0;j<waterStartTime.length;j++){
                // land -> water
                int lastEnd = landStartTime[i] + landDuration[i];
                int waterStart = Math.max(lastEnd, waterStartTime[j]);
                int finish1 = waterStart + waterDuration[j];


                // water -> land

                int waterEnd =  waterStartTime[j] + waterDuration[j];
                int landStart = Math.max(waterEnd, landStartTime[i]);
                int finish2 = landStart + landDuration[i];

                int bestForThisPair = Math.min(finish1, finish2);
                answer = Math.min(answer, bestForThisPair);
            }
        }
        return answer;
    }
}