class Solution {
    public int[] transformArray(int[] nums) {
        int even = 0;
        int odd = 0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2 == 0)
            {
                even++;
            }
        }

        int[] ans = new int[nums.length];

        for(int i=even;i<ans.length;i++)
        {
            ans[i] = 1;
        }

        return ans;
    }
}