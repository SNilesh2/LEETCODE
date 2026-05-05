class Pair
{
    int score;
    int ind;
    public Pair(int score,int ind)
    {
        this.score = score;
        this.ind = ind;
    }
}

class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.score - a.score);

        String[] result = new String[score.length];

        for(int i=0;i<score.length;i++)
        {
            pq.offer(new Pair(score[i],i));
        }

        int rank = 1;

        for(int i=0;i<score.length;i++)
        {
            Pair p = pq.poll();

            if(rank==1)
            {
                result[p.ind] = "Gold Medal";
            }
            else if(rank==2)
            {
                result[p.ind] = "Silver Medal";
            }
            else if(rank==3)
            {
                result[p.ind] = "Bronze Medal";
            }
            else
            {
                result[p.ind] = String.valueOf(rank);
            }
            rank++;
        }

        return result;
    }
}