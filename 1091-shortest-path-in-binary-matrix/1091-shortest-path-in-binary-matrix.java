class Pair
{
    int dis;
    int row;
    int col;
    public Pair(int dis,int row,int col)
    {
        this.dis = dis;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1]== 1)
        {
            return -1;
        }

        if(n==1 && grid[0][0]==0)
        {
            return 1;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1,0,0));

        int[][] distance = new int[n][n];
        for(int[] arr : distance)
        {
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        int[] drow = {-1,-1,0,1,1,1,0,-1};
        int[] dcol = {0,1,1,1,0,-1,-1,-1};
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int dis = p.dis;
            int row = p.row;
            int col = p.col;

            for(int i=0;i<8;i++)
            {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==0 && distance[nrow][ncol] > dis+1)
                {
                    distance[nrow][ncol] = dis+1;
                    q.add(new Pair(dis+1,nrow,ncol));
                    if(nrow==n-1 && ncol==n-1)
                    {
                        return distance[n-1][n-1];
                    }
                }
            }
        }
        return -1;
    }
}