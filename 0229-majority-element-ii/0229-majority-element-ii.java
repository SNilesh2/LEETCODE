class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if(nums==null || nums.length==0)
        {
            return res;
        }
        int candidate1=0,candidate2=0,cnt1=0,cnt2=0;
        for(int num:nums)
        {
            if(candidate1==num)
            {
                cnt1++;
            }
            else if(candidate2==num)
            {
                cnt2++;
            }
            else if(cnt1==0)
            {
                candidate1=num;
                cnt1++;
            }
            else if(cnt2==0)
            {
                candidate2=num;
                cnt2++;
            }
            else
            {
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int num:nums)
        {
            if(candidate1==num)
            {
                cnt1++;
            }
            else if(candidate2==num)
            {
                cnt2++;
            }
        }
        if(cnt1>(nums.length/3))
        {
            res.add(candidate1);
        }
        if(cnt2>(nums.length/3)) 
        {
            res.add(candidate2);
        }
        return res;
    }
}