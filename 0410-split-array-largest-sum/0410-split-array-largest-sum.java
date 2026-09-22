class Solution {
    public int splitArray(int[] nums, int k) {
        int size = nums.length;

        long maxi = Integer.MIN_VALUE;
        long totalPages = 0;

        for(int i=0;i<nums.length;i++)
        {
            maxi = Math.max(maxi,nums[i]);
            totalPages = totalPages + nums[i];
        }

        long low = maxi;
        long high = totalPages;
        long ans = -1;
        while(low <= high)
        {
            long mid = low + (high - low)/2;

            if(possible(mid,k,nums))
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return (int)ans;
    }
    public boolean possible(long allowedSum,int k,int[] nums)
    {
        int count = 1;
        long sum = 0;

        for(int i=0;i<nums.length;i++)
        {
            if(sum + nums[i] > allowedSum)
            {
                count++;
                sum = nums[i];

                if(count > k)
                {
                    return false;
                }
            }
            else
            {
                sum = sum + nums[i];
            }
        }

        return true;
    }
}