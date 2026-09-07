class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];

        return findMinTotal(triangle,dp);
    }

    public int findMinTotal(List<List<Integer>> triangle,int[][] dp)
    {
        // if(r==0 && c==0)
        // {
        //     return triangle.get(0).get(0);
        // }
        // if(c<0 || c>=triangle.get(r).size())
        // {
        //     return Integer.MAX_VALUE;
        // }
        // if(dp[r][c]!=-1)
        // {
        //     return dp[r][c];
        // }
        // int upLeft = findMinTotal(r-1,c-1,triangle,dp);
        // int upRight = findMinTotal(r-1,c,triangle,dp);
        // return dp[r][c] = triangle.get(r).get(c) + Math.min(upLeft,upRight);
        for(int i=0;i<triangle.size();i++)
        {
            for(int j=0;j<triangle.get(i).size();j++)
            {
                if(i==0 && j==0)
                {
                    dp[0][0] = triangle.get(0).get(0);
                    continue;
                }

                int upLeft = Integer.MAX_VALUE;

                if(j-1 >= 0)
                {
                    upLeft = dp[i-1][j-1];
                }

                int upRight = Integer.MAX_VALUE;

                if(j<triangle.get(i-1).size())
                {
                    upRight = dp[i-1][j];
                }

                dp[i][j] = triangle.get(i).get(j) + Math.min(upLeft,upRight);
            }
        }

        int mini = Integer.MAX_VALUE;
        int size = triangle.size();
        for(int i=0;i<triangle.get(size-1).size();i++)
        {
            mini = Math.min(mini,dp[size-1][i]); 
        }

        return mini;
    }
}