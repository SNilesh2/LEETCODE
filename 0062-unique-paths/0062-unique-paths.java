class Solution {
    public int uniquePaths(int m, int n) {
       /* int N=m+n-2;
        int r=m-1;
        double res=1;
        for(int i=1;i<=r;i++)
        {
            res=res * (N-r+i)/i;
        }
        return (int)res;*/
        int[][] dp=new int[m][n];
        return fun(m,n,dp);
    }
    public static int fun(int m,int n,int[][] dp)
    {
        for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(i==0 && j==0) dp[0][0]=1;
            else
            {
                int up=0,left=0;
                if(i>0) up=dp[i-1][j];
                if(j>0) left=dp[i][j-1];
                dp[i][j]=up+left;
            }
        }
    }
        return dp[m-1][n-1];
    }
   
}