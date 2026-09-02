class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return findMax(nums.length-1,nums,dp);
    }
    public static int findMax(int ind,int[] nums,int[] dp)
    {
        if(ind==0)
        {
            return nums[0];
        }

        if(ind<0)
        {
            return 0;
        }

        if(dp[ind]!=-1)
        {
            return dp[ind];
        }

        int pick = nums[ind] + findMax(ind-2,nums,dp);

        int notpick = 0 + findMax(ind-1,nums,dp);

        return dp[ind] = Math.max(pick,notpick);
    }
}