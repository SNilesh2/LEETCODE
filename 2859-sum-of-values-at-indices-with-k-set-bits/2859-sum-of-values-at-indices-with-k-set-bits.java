class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for(int i=0;i<nums.size();i++)
        {
            int val = i;

            int count = 0;
            while(val>0)
            {
                if((val & 1) == 1)
                {
                    count++;
                }
                val = val >> 1;
            }

            if(count==k)
            {
                sum = sum + nums.get(i);
            }
        }
        return sum;
    }
}