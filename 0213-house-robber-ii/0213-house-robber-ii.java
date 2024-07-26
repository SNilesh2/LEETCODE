class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] temp1=new int[nums.length-1];
        int[] temp2=new int[nums.length-1];
        for(int i=0;i<nums.length;i++)
        {
            if(i!=0) temp1[i-1]=nums[i];
            if(i!=nums.length-1) temp2[i]=nums[i];
        }
        return Math.max(solve(nums.length-1,temp1),solve(nums.length-1,temp2)); 
    }
    public static int solve(int n,int[] nums)
    {
        int prev1=nums[0];
        int prev2=0;
        for(int ind=1;ind<n;ind++)
        {
            int pick=nums[ind];
            if(ind>1) pick=pick+prev2;
            int notpick=0+prev1;
            int curri=Math.max(pick,notpick);
            prev2=prev1;
            prev1=curri;
        }
        return prev1;
    }
}