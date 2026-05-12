class Pair
{
    int val;
    int ind;
    public Pair(int val,int ind)
    {
        this.val = val;
        this.ind = ind;
    }
}
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(int i=0;i<nums.length;i++)
        {
            pq.add(new Pair(nums[i],i));
            if(pq.size() > k)
            {
                pq.poll();
            }
        }

        PriorityQueue<Pair> sortByInd = new PriorityQueue<>((a,b) -> a.ind - b.ind);

        while(!pq.isEmpty())
        {
            Pair polled = pq.poll();

            sortByInd.add(new Pair(polled.val,polled.ind));
        }

        int[] ans = new int[k];

        for(int i=0;i<k;i++)
        {
            ans[i] = sortByInd.poll().val;
        }

        return ans;
    }
}