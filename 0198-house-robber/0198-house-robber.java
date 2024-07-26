class Solution {
    public int rob(int[] nums) {
        return solve(nums.length,nums);
    }
    public static int solve(int n,int[] nums)
    {
        int prev1=nums[0];
        int prev2=0;
        for(int ind=1;ind<n;ind++)
        {
            int pick=nums[ind];
            if(ind>1) pick=pick+prev2;
            int notpick=0+prev1;
            int curri=Math.max(pick,notpick);
            prev2=prev1;
            prev1=curri;
        }
        return prev1;
    }
}