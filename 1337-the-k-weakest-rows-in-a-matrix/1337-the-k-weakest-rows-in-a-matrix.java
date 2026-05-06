class Pair {
    int ind;
    int maxOnes;

    public Pair(int ind, int maxOnes) {
        this.ind = ind;
        this.maxOnes = maxOnes;
    }
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->
        {
            if(a.maxOnes != b.maxOnes)
                {
                  return a.maxOnes - b.maxOnes;
                }
                else
                {
                  return a.ind - b.ind;
                }
        });

        for(int i=0;i<row;i++)
        {
            int noOfOnes = 0;
            for(int j=0;j<col;j++)
            {
                if(mat[i][j]==1)
                {
                    noOfOnes++;
                }
                else
                {
                    break;
                }
            }
            pq.offer(new Pair(i,noOfOnes));
        }

        int[] result = new int[k];

        for(int i=0;i<k;i++)
        {
            result[i] = pq.poll().ind;
        }

        return result;
    }
}