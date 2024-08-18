class Pair
{
    int row;
    int col;
    int step;
    public Pair(int _row,int _col,int _step)
    {
        this.row=_row;
        this.col=_col;
        this.step=_step;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[m][n];
        int[][] res=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0) 
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            int s=curr.step;
            res[r][c]=s;
            int[] drow={-1,0,1,0};
            int[] dcol={0,1,0,-1};
            for(int i=0;i<4;i++)
            {
                int adjrow=r+drow[i];
                int adjcol=c+dcol[i];
                if(adjrow>=0 && adjrow<m && adjcol>=0 && adjcol<n && vis[adjrow][adjcol]==0 )
                {
                    q.add(new Pair(adjrow,adjcol,s+1));
                    vis[adjrow][adjcol]=1;
                }
            }
        }
        return res;
    }
}