class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low=1;
        int high=max(quantities);
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            System.out.println("mid : " + mid);
            if(isPossible(quantities,mid,n))
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] quantities,int max,int n)
    {
        int len=quantities.length;
        int count=0;
        for(int i=0;i<len;i++)
        {
            count=count + (int)Math.ceil((double) quantities[i]/max);
        }

        if(count<=n)
        {
            return true;
        }
        return false;
    }

    public static int max(int[] quantities)
    {
        int maxi=Integer.MIN_VALUE;
        int n=quantities.length;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(maxi,quantities[i]);
        }
        return maxi;
    }

    public static int sum(int[] quantities)
    {
        int sum=0;
        int n=quantities.length;

        for(int i=0;i<n;i++)
        {
            sum=sum+quantities[i];
        }
        return sum;
    }
}