class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        if(nums.length>threshold) return -1;
        int maxi=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(maxi,nums[i]);
        }
        int low=1,high=maxi;
        int ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int sum=divisor(nums,threshold,mid);
            if(sum<=threshold)
            {
                ans=Math.min(ans,mid);
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
    public static int divisor(int[] nums,int threshold,int mid)
    {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=Math.ceil((double)nums[i]/(double)mid);
        }
        return sum;
    }
}