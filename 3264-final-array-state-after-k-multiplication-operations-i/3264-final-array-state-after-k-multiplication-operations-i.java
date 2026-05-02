class Pair
{
    int value;
    int ind;
    public Pair(int value, int ind)
    {
        this.value = value;
        this.ind = ind;
    }
}

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.value != b.value)
            {
                return a.value - b.value;
            }
            else
            {
                return a.ind - b.ind;
            }
        }
        );

        for(int i=0;i<nums.length;i++)
        {
            pq.offer(new Pair(nums[i],i));
        }

        int operation = 0;

        while(operation < k)
        {
            Pair p = pq.poll();

            int multipliedValue = p.value * multiplier;
            int  ind = p.ind;

            nums[ind] = multipliedValue;

            pq.offer(new Pair(multipliedValue,ind));

            operation++;
        }

        return nums;
    }
}