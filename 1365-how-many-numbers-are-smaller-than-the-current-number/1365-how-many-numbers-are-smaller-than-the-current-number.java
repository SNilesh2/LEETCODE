class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[] copy=nums.clone();

        HashMap<Integer,Integer> map=new HashMap<>();
        Arrays.sort(copy);

        for(int i=0;i<n;i++)
        {
            map.putIfAbsent(copy[i],i);
        }

        for(int i=0;i<n;i++)
        {
            copy[i]=map.get(nums[i]);
        }
        return copy;
    }
}