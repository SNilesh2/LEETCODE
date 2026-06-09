class Pair
{
    int row;
    int col;
    public Pair(int row,int col)
    {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] result = new int[rows][cols];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new Pair(i,j));
                }
                else 
                {
                    result[i][j] = -1;
                }
            }
        }

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;

            for(int i=0;i<4;i++)
            {
                int nr = r + drow[i];
                int nc = c + dcol[i];

                if(nr>=0 && nr<rows && nc>=0 && nc<cols && result[nr][nc]==-1)
                {
                    result[nr][nc] = result[r][c] + 1;
                    q.add(new Pair(nr,nc));
                }
            }
        }
        return result;
    }
}