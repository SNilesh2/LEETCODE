class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0,maxlength=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                count++;
                maxlength=Math.max(maxlength,count);
            }
            else
            {
                count=0;
            }
        }
        return  maxlength;
    }
}