class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long res = 0;
        long maxMinValue = nums[n-1];

        long result = 0;
        for(int i=n-2;i>=0;i--)
        {
            long parts = (long)Math.ceil(nums[i] / (double)maxMinValue);

            result = result + (parts-1);

            maxMinValue = nums[i]/parts;
        }

        return result;
    }
}