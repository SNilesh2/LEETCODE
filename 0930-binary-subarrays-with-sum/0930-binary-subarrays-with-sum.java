class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return findTotalSub(nums,goal) - findTotalSub(nums,goal-1);
    }

    public static int findTotalSub(int[] nums,int goal)
    {
        if(goal < 0)
        {
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int total = 0;

        while(right < nums.length)
        {
            sum = sum + nums[right];

            while(sum > goal)
            {
                sum = sum - nums[left];
                left++;
            }

            if(sum <= goal)
            {
                total = total + (right - left + 1);
            }

            right++;
        }

        return total;
    }
}