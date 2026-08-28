class Pair
{
    int r;
    int c;
    public Pair(int r,int c)
    {
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int col = image[0].length;

        int original = image[sr][sc];

        if(original==color)
        {
            return image;
        }

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(sr,sc));
        image[sr][sc] = color;

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(!q.isEmpty())
        {
            Pair polled = q.poll();

            int r = polled.r;
            int c = polled.c;

            for(int i=0;i<4;i++)
            {
                int nr = r + drow[i];
                int nc = c + dcol[i];

                if(nr>=0 && nr<row && nc>=0 && nc<col && image[nr][nc]==original)
                {
                    image[nr][nc] = color;
                    q.add(new Pair(nr,nc));
                }
            }
        }

        return image;
    }
}