class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set= new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);

            int num = nums[i];

            int reversed = 0;
            while(num > 0)
            {
                int last = num % 10;
                reversed = reversed * 10 + last;
                num = num/10;
            }

            set.add(reversed);
        }

        return set.size();
    }
}