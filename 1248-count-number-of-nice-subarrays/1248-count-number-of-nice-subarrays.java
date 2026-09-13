class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return findNiceArray(nums,k) - findNiceArray(nums,k-1);
    }

    public int findNiceArray(int[] nums,int k)
    {
        int left = 0;
        int right = 0;
        int total = 0;
        int cnt = 0;

        while(right < nums.length)
        {
            if(nums[right]%2==1)
            {
                cnt++;
            }

            while(cnt > k)
            {
                if(nums[left]%2==1)
                {
                    cnt--;
                }
                left++;
            }


            if(cnt <= k)
            {
                total = total + (right - left + 1);
            }

            right++;
        }

        return total;
    }
}