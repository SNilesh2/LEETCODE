class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        if(n<3)
        {
            return 0;
        }

        int left=0;
        int right=1;
        int result=0;
        int diff=nums[0]-nums[1];
        while(right<n)
        {
            int tempdiff=nums[right-1]-nums[right];
            int len=right-left+1;
            if((tempdiff==diff) && len>=3)
            {
                result=result+(len-3+1);
            }
            if(tempdiff!=diff)
            {
                diff=nums[right-1]-nums[right];
                left=right-1;
            }
            right++;
        }
        return result;
    }
}