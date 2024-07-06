class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=max(piles);
        int ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int totalhours=findtotalhours(piles,mid);
            if(totalhours<=h)
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
    public static int max(int[] piles)
    {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++)
        {
            maxi=Math.max(maxi,piles[i]);
        }
        return maxi;
    }
    public static int findtotalhours(int[] piles,int mid)
    {
        int totalhours=0;
        for(int i=0;i<piles.length;i++)
        {
            totalhours+=Math.ceil((double)piles[i]/(double)mid);
        }
        return totalhours;
    }
}