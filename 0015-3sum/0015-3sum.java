class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<3)
        {
            return result;
        }

        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<=n-3;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            int j = i+1;
            int k = n-1;

            while(j<k)
            {
                long sum = nums[i] + nums[j] + nums[k];

                if(sum==0)
                {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    j++;
                    k--;
                    while(j<n && nums[j]==nums[j-1])
                    {
                        j++;
                    }
                    while(k>=0 && nums[k]==nums[k+1])
                    {
                        k--;
                    }
                }
                else if(sum<0)
                {
                    j++;
                    while(j<n && nums[j]==nums[j-1])
                    {
                        j++;
                    }
                }
                else
                {
                    k--;
                    while(k>=0 && nums[k]==nums[k+1])
                    {
                        k--;
                    }
                }
            }
        }

        return result;
    }
}