class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1 = nums[0];
        int ele2 = Integer.MAX_VALUE;

        int count1 = 1;
        int count2 = 0;

        for(int i=1;i<nums.length;i++)
        {
            if(count1==0 && nums[i]!=ele2)
            {
                ele1 = nums[i];
                count1++;
            }
            else if(count2==0 && nums[i]!=ele1)
            {
                ele2 = nums[i];
                count2++;
            }
            else if(nums[i]==ele1)
            {
                count1++;
            }
            else if(nums[i]==ele2)
            {
                count2++;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(ele1==nums[i])
            {
                cnt1++;
            }
            else if(ele2==nums[i])
            {
                cnt2++;
            }
        }

        int n= nums.length;
        if(cnt1 > n/3)
        {
            result.add(ele1);
        }
        if(cnt2 > n/3)
        {
            result.add(ele2);
        }

        return result;
    }
}