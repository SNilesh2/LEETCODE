class Pair
{
    int row;
    int col;
    int time;

    public Pair(int row,int col,int time)
    {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();


        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                }
            }
        }

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        int result = 0;
        while(!q.isEmpty())
        {
            Pair polled = q.poll();

            int r = polled.row;
            int c = polled.col;
            int t = polled.time;

            result = Math.max(result,t);

            for(int i=0;i<4;i++)
            {
                int nr = r + drow[i];
                int nc = c + dcol[i];

                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1)
                {
                    grid[nr][nc] = 2;
                    q.add(new Pair(nr,nc,t+1));
                }
            }
        }


        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    return -1;
                }
            }
        }


        return result;
    }
}