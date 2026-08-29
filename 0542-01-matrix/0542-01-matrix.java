class Pair
{
    int r;
    int c;
    int dis;
    public Pair(int r ,int c,int dis)
    {
        this.r = r;
        this.c = c;
        this.dis = dis;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();

        int[][] vis = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                {
                    vis[i][j] = 1;
                    q.add(new Pair(i,j,0));
                }
            }
        }

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(!q.isEmpty())
        {
            Pair p = q.poll();

            int r = p.r;
            int c = p.c;
            int dis = p.dis;

            for(int i=0;i<4;i++)
            {
                int nr = r + drow[i];
                int nc = c + dcol[i];

                if(nr>=0 && nr<mat.length && nc>=0 && nc<mat[0].length && vis[nr][nc]==0 && mat[nr][nc]==1)
                {
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr,nc,dis+1));
                    mat[nr][nc] = dis + 1;
                }
            }
        }

        return mat;
    }
}