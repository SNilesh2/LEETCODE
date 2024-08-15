class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int[][] ans=image;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        int initialcolour=image[sr][sc];
        dfs(image,ans,drow,dcol,sr,sc,color,initialcolour,n,m);
        return ans;
    }
    public static void dfs(int[][] image,int[][] ans,int[] drow,int[] dcol,int r,int c,int color,int initialcolour,int n,int m)
    {
        ans[r][c]=color;
        for(int i=0;i<4;i++)
        {
            int nrow=r+drow[i];
            int ncol=c+dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==initialcolour && ans[nrow][ncol]!=color)
            {
                dfs(image,ans,drow,dcol,nrow,ncol,color,initialcolour,n,m);
            }
        }
    }
}