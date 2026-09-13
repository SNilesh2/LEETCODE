class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return findSubArray(nums,k) - findSubArray(nums,k-1);
    }

    public int findSubArray(int[] nums,int k)
    {
        int right = 0;
        int left = 0;
        int total = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();

        while(right < nums.length)
        {
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            while(map.size() > k)
            {
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0)
                {
                    map.remove(nums[left]);
                }
                left++;
            }


            if(map.size()<=k)
            {
                total = total + (right - left + 1);
            }

            right++;
        }

        return total;
    }
}