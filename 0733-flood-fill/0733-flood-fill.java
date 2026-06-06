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
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        int rowLen = image.length;
        int colLen = image[0].length;

        int[][] vis = new int[rowLen][colLen];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        vis[sr][sc] = 1;

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(!q.isEmpty())
        {
            Pair p = q.poll();

            int row = p.row;
            int col = p.col;

            image[row][col] = color;

            for(int i=0;i<4;i++)
            {
                int newRow = row + drow[i];
                int newCol = col + dcol[i];

                if(newRow>=0 && newRow<rowLen && newCol>=0 && newCol<colLen && vis[newRow][newCol]==0 && image[newRow][newCol]==original)
                {
                    vis[newRow][newCol] = 1;
                    q.add(new Pair(newRow,newCol));
                }
            }
        }
        return image;
    }
}