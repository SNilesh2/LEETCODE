class Solution {
    public int minElement(int[] nums) {
        int mini = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++)
        {
            int num = nums[i];
            int sum = 0;

            while(num > 0)
            {
                int lastDigit = num % 10;
                sum = sum + lastDigit;
                num = num/10;
            }

            mini = Math.min(mini,sum);
        }
        return mini;
    }
}