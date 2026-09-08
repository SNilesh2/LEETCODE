class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int length = matrix.length;

        int[][] dp = new int[length][length];

        return findMinSum(matrix,dp);
    }

    public int findMinSum(int[][] matrix,int[][] dp)
    {
        // if(c<0 || c>=matrix.length)
        // {
        //     return Integer.MAX_VALUE;
        // }
        // if(r==0)
        // {
        //     return matrix[0][c];
        // }
        // if(dp[r][c]!=-1)
        // {
        //     return dp[r][c];
        // }
        // int mini = Integer.MAX_VALUE;
        // for(int i=-1;i<=1;i++)
        // {
        //     mini = Math.min(mini,findMinSum(r-1,c+i,matrix,dp));
        // }
        // return dp[r][c] = matrix[r][c] + mini;

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                if(i==0)
                {
                    dp[0][j] = matrix[0][j];
                    continue;
                }

                int upLeft = Integer.MAX_VALUE;
                if(j-1 >= 0)
                {
                    upLeft = dp[i-1][j-1];
                }

                int up = dp[i-1][j];

                int upRight = Integer.MAX_VALUE;
                if(j+1 < matrix.length)
                {
                    upRight = dp[i-1][j+1];
                }

                dp[i][j] = matrix[i][j] + Math.min(upLeft,Math.min(up,upRight));
            }
        }

        int mini = Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++)
        {
            mini = Math.min(mini,dp[matrix.length-1][i]);
        }

        return mini;
    }
}