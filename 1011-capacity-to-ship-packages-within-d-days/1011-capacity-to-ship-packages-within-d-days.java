class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int maxi=Integer.MIN_VALUE,sum=0;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(maxi,weights[i]);
            sum+=weights[i];
        }
        int low=maxi,high=sum;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int noofdays=finddays(weights,mid);
            if(noofdays<=days)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
    public static int finddays(int[] weights,int cap)
    {
        int day=1,load=0;
        for(int i=0;i<weights.length;i++)
        {
            if(load+weights[i]>cap)
            {
                day+=1;
                load=weights[i];
            }
            else
            {
                load+=weights[i];
            }
        }
        return day;
    }
}