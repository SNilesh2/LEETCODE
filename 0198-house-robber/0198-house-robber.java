class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        findMax(nums,dp);
        return dp[nums.length-1];
    }
    public static void findMax(int[] nums,int[] dp)
    {
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int pick = nums[i];
            if(i-2 >= 0)
            {
                pick = pick + dp[i-2];  
            }
            int notpick = Integer.MIN_VALUE;
            if(i-1 >= 0)
            {
                notpick = 0 + dp[i-1];
            }

            dp[i] = Math.max(pick,notpick);
        }
    }
}