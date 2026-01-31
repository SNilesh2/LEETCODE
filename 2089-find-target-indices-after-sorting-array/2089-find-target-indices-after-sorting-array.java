class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result=new ArrayList<>();
        int n=nums.length;

        int countLess=0;
        int countEqual=0;

        for(int i=0;i<n;i++)
        {
            if(nums[i]<target)
            {
                countLess++;
            }
            else if(nums[i]==target)
            {
                countEqual++;
            }
        }

        for(int i=0;i<countEqual;i++)
        {
            result.add(countLess+i);
        }
        
        return result;
    }
}