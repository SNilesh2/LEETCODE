class Solution {
    public int longestOnes(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;
        while(right < nums.length)
        {
            if(nums[right]==1)
            {
                maxLength = Math.max(maxLength , right - left + 1);
                right++;
            }
            else
            {
                if(zeroCount < k)
                {
                    zeroCount++;
                    maxLength = Math.max(maxLength, right - left + 1);
                    right++;
                }
                else
                {
                    while(zeroCount>=k)
                    {
                        if(nums[left]==0)
                        {
                            zeroCount--;
                        }
                        left++;
                    }
                }
            }
        }

        return maxLength;
    }
}