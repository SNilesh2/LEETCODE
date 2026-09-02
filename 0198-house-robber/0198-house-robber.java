class Solution {
    public int rob(int[] nums) {
        int prev2 = 0;
        int prev1 = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int pick = nums[i];
            if(i-2 >= 0)
            {
                pick = pick + prev2;  
            }
            int notpick = Integer.MIN_VALUE;
            if(i-1 >= 0)
            {
                notpick = 0 + prev1;
            }

            int curr = Math.max(pick,notpick);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}