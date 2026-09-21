class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = 0;
        for(int i=0;i<piles.length;i++)
        {
            maxi = Math.max(maxi,piles[i]);
        }
        int low = 1;
        int high = maxi;

        while(low<=high)
        {
            int mid = low + (high - low)/2;

            if(isPossible(mid,piles,h))
            {
                high = mid - 1;
            }
            else 
            {
                low = mid + 1;
            }
        }
        return low;
    }
    public static boolean isPossible(int k,int[] piles,int h)
    {
        double hours = 0.0;

        for(int i=0;i<piles.length;i++)
        {
            hours = hours + Math.ceil((double)piles[i]/(double)k);
        }
        
        if(hours<=h)
        {
            return true;
        }

        return false;
    }
}