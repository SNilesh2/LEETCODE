class Pair
{
    int row;
    int col;
    int diff;
    public Pair(int row,int col,int diff)
    {
        this.row = row;
        this.col = col;
        this.diff = diff;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] distance = new int[rows][cols];
        for(int[] arr : distance)
        {
            Arrays.fill(arr,Integer.MAX_VALUE);

        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.diff-b.diff);

        pq.add(new Pair(0,0,0));

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();

            int row = p.row;
            int col = p.col;
            int diff = p.diff;

            if(row==rows-1 && col==cols-1)
            {
                return diff;
            }
            for(int i=0;i<4;i++)
            {
                int nrow = row+drow[i];
                int ncol = col+dcol[i];

                if(nrow>=0 && nrow<rows && ncol>=0 && ncol<cols)
                {
                    int effort = Math.max(diff,Math.abs(heights[row][col]-heights[nrow][ncol]));


                    if(effort < distance[nrow][ncol])
                    {
                        distance[nrow][ncol] = effort;
                        pq.add(new Pair(nrow,ncol,effort));
                    }
                }
            }
        }
        return 0;
    }
}