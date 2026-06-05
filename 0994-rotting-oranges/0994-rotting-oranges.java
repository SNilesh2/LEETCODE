class Pair
{
    int row;
    int col;
    int minute;

    public Pair(int row,int col,int minute)
    {
        this.row = row;
        this.col = col;
        this.minute = minute;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int maxMinute = 0;
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                }
                if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }

        if(fresh==0)
        {
            return 0;
        }

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        int cnt = 0;
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int m = p.minute;
            

            for(int i=0;i<4;i++)
            {
                int newRow = r + drow[i];
                int newCol = c + dcol[i];


                if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol]==1)
                {
                    maxMinute = Math.max(maxMinute,m+1);
                    grid[newRow][newCol] = 2;
                    q.add(new Pair(newRow,newCol,m+1));
                    cnt++;
                }
            }
        }

        if(fresh!=cnt)
        {
            return -1;
        }


        return maxMinute;
    }
}