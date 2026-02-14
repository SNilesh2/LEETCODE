class Pair
{
    int diff;
    int prof;

    public Pair(int diff,int prof)
    {
        this.diff=diff;
        this.prof=prof;
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n=worker.length;
        List<Pair> list=new ArrayList<>();
        int total=0;

        int jobLen=difficulty.length;
        for(int i=0;i<jobLen;i++)
        {
            list.add(new Pair(difficulty[i],profit[i]));
        }

        Collections.sort(list,(a,b)->a.diff-b.diff);

        int maxi=list.get(0).prof;
        for(int i=1;i<jobLen;i++)
        {
            maxi=Math.max(maxi,list.get(i).prof);
            list.set(i,new Pair(list.get(i).diff,maxi));
        }

        for(int i=0;i<n;i++)
        {
            total=total + findProfit(list,worker[i]);
        }
        return total;
    }
    public static int findProfit(List<Pair> list,int worker)
    {
        int low=0;
        int high=list.size()-1;

        int profit=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;

            Pair p=list.get(mid);

            if(p.diff<=worker)
            {
                profit=p.prof;

                //System.out.println(p.diff + " " + profit);
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        //System.out.println(profit);
        return profit;
    }
}