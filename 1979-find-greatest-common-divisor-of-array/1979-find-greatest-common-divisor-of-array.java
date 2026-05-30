class Solution {
    public int findGCD(int[] nums) {
        int mini = 1001;
        int maxi = 0;
        for(int i=0;i<nums.length;i++)
        {
            mini = Math.min(mini,nums[i]);
            maxi = Math.max(maxi,nums[i]);
        }

        int result = 1;

        for(int i=1;i<=maxi;i++)
        {
            if((mini%i == 0) && (maxi%i == 0))
            {
                result = i;
            }
        }

        return result;
    }
}