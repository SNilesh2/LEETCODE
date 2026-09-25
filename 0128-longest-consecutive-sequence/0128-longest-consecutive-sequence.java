class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }

        int maxi = 0;
        for(int i=0;i<nums.length;i++)
        {
            int length = 1;
            if(!set.contains(nums[i]-1) && set.contains(nums[i]))
            {
                set.remove(nums[i]);

                int x = nums[i];
                while(set.contains(x + 1))
                {
                    length++;
                    set.remove(x+1);
                    x = x + 1;
                }
                maxi = Math.max(maxi,length);
            }
        }

        return maxi;
    }
}