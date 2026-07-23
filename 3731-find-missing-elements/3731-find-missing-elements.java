class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            mini = Math.min(mini,nums[i]);
            maxi = Math.max(maxi,nums[i]);
            set.add(nums[i]);
        }

        List<Integer> result = new ArrayList<>();
        for(int i=mini;i<maxi;i++)
        {
            if(!set.contains(i))
            {
                result.add(i);
            }
        }

        return result;
    }
}