class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val=(long)m*(long)k;
        if(val>bloomDay.length) return -1;
        int mini=Integer.MAX_VALUE;
        int n=bloomDay.length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            mini=Math.min(mini,bloomDay[i]);
            maxi=Math.max(maxi,bloomDay[i]);
        }
        int low=mini,high=maxi;
        int ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(possible(bloomDay,mid,m,k))
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
    public static boolean possible(int[] bloomDay,int mid,int m,int k)
    {
        int count=0,noofbouquets=0;
        for(int i=0;i<bloomDay.length;i++)
        {
            if(bloomDay[i]<=mid)
            {
                count++;
            }
            else
            {
                noofbouquets+=(count/k);
                count=0;
            }
        }
        noofbouquets+=(count/k);
        return noofbouquets>=m;
    }
}