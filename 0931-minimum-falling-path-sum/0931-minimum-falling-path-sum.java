class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int length = matrix.length;

        return findMinSum(matrix);
    }

    public int findMinSum(int[][] matrix)
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

        int[] prev = new int[matrix.length];

        for(int i=0;i<matrix.length;i++)
        {
            int[] curr = new int[matrix.length];
            for(int j=0;j<matrix.length;j++)
            {
                if(i==0)
                {
                    curr[j] = matrix[0][j];
                    continue;
                }

                int upLeft = Integer.MAX_VALUE;
                if(j-1 >= 0)
                {
                    upLeft = prev[j-1];
                }

                int up = prev[j];

                int upRight = Integer.MAX_VALUE;
                if(j+1 < matrix.length)
                {
                    upRight = prev[j+1];
                }

                curr[j] = matrix[i][j] + Math.min(upLeft,Math.min(up,upRight));
            }

            prev = curr;
        }

        int mini = Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++)
        {
            mini = Math.min(mini,prev[i]);
        }

        return mini;
    }
}