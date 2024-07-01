class Solution {
    public int minMaxGame(int[] nums) {
        while(nums.length>1)
        {
            int[] newnums=new int[nums.length/2];
            for(int i=0;i<nums.length/2;i++)
            {
                if(i%2==0)
                {
                    newnums[i]=Math.min(nums[2*i],nums[2*i+1]);
                }
                else
                {
                    newnums[i]=Math.max(nums[2*i],nums[2*i+1]);
                }
            }
            nums=newnums;
        }
        return nums[0];
    }
}