class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;
        for(int i=0;i<nums.length;i++)
        {
            String str = Integer.toString(nums[i]);

            for(int j=0;j<str.length();j++)
            {
                if((str.charAt(j) - '0') == digit)
                {
                    count++;
                }
            }
        }

        return count;
    }
}