class Tuple
{
    int time;
    int r;
    int c;
    public Tuple(int time,int r,int c)
    {
        this.time = time;
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] vis = new int[n][n];

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->a.time - b.time);
        pq.add(new Tuple(grid[0][0],0,0));
        vis[0][0] = 1;

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!pq.isEmpty())
        {
            Tuple polled = pq.poll();

            int time = polled.time;
            int r = polled.r;
            int c = polled.c;

            if(r==n-1 && c==n-1)
            {
                return time;
            }

            for(int i=0;i<4;i++)
            {
                int nr = r + drow[i];
                int nc = c + dcol[i];

                if(nr>=0 && nr<n && nc>=0 && nc<n && vis[nr][nc]==0)
                {
                    vis[nr][nc] = 1;
                    pq.add(new Tuple(Math.max(time,grid[nr][nc]),nr,nc));
                }
            }
        }

        return 0;
    }
}