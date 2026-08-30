class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length==1) return 1;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            mini = Math.min(mini, nums[i]);
            maxi = Math.max(maxi , nums[i]);
        }
        int index1 = -1, index2 = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == mini) index1 = i+1;
            if(nums[i] == maxi) index2 = i+1;
        }
       // System.out.println(index1);
      //   System.out.println(index2);
        int back1 = nums.length+1-index1;
        int back2 = nums.length+1-index2;
      //  System.out.println(back1);
       //  System.out.println(back2);
         int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
         a = Math.max(back1, back2);
         b = Math.max(index1, index2);
        int c = Math.min(a,b);
     //   System.out.println(c);
        return Math.min((Math.min(back1, index1) + Math.min(back2, index2)), c);
    }
}