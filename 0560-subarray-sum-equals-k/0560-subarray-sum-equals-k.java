class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixsum=0,count=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            prefixsum=prefixsum+nums[i];
            int remove=prefixsum-k;
            count=count+map.getOrDefault(remove,0);
            map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);
        }
        return count;
    }
}