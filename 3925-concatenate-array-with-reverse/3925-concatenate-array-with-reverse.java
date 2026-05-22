class Solution {
    public int[] concatWithReverse(int[] nums) {
        int[] result = new int[nums.length * 2];

        for(int i=0;i<nums.length;i++)
        {
            result[i] = nums[i];
        }

        int j = nums.length;
        for(int i=nums.length-1;i>=0;i--)
        {
            result[j++] = nums[i];
        }

        return result;
    }
}