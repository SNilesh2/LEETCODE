class Solution {
    public int triangularSum(int[] nums) {
        while(nums.length>1)
        {
            int[] newnums=new int[nums.length-1];
            for(int i=0;i<nums.length-1;i++)
            {
                newnums[i]=(nums[i]+nums[i+1])%10;
            }
            nums=newnums;
        }
        return nums[0];
    }
}