class Solution {
    public long repairCars(int[] ranks, int cars) {
        int n=ranks.length;
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {
            mini=Math.min(mini,ranks[i]);
            maxi=Math.max(maxi,ranks[i]);
        }
        long low=mini;
        long high=maxi * cars * cars;
        long answer=0;
        while(low<=high)
        {
            long mid=low+(high-low)/2;

            if(possible(ranks,mid,cars))
            {
                answer=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return answer;
    }
    public static boolean possible(int[] ranks,long val,int cars)
    {
        int n=ranks.length;
        int count=0;
        
        for(int i=0;i<n;i++)
        {
            long low=1;
            long high= (long)Math.ceil(Math.sqrt(val));
            long answer=0;

            while(low<=high)
            {
               long mid=low+(high-low)/2;

               if(ranks[i] * mid * mid <= val)
               {
                 answer=mid;
                 low=mid+1;
               }
               else
               {
                 high=mid-1;
               }
            }
            count= (int)(count + answer);
        }
        if(count>=cars)
        {
            return true;
        }
        return false;
    }
}