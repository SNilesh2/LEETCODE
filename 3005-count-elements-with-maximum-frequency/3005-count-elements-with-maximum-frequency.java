class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int maxFreq = 0;
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            if(map.get(nums[i]) > maxFreq)
            {
                maxFreq = map.get(nums[i]);
            }
        }

        int result = 0;
        for(Map.Entry<Integer,Integer> en : map.entrySet())
        {
            if(en.getValue() == maxFreq)
            {
                result = result + en.getValue();
            }
        }

        return result;
    }
}