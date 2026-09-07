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

        int[] prev = new int[triangle.size()];
        for(int i=0;i<triangle.size();i++)
        {
            int[] curr = new int[triangle.size()];

            for(int j=0;j<triangle.get(i).size();j++)
            {
                if(i==0 && j==0)
                {
                    curr[0] = triangle.get(0).get(0);
                    continue;
                }

                int upLeft = Integer.MAX_VALUE;

                if(j-1 >= 0)
                {
                    upLeft = prev[j-1];
                }

                int upRight = Integer.MAX_VALUE;

                if(j<triangle.get(i-1).size())
                {
                    upRight = prev[j];
                }

                curr[j] = triangle.get(i).get(j) + Math.min(upLeft,upRight);
            }
            prev = curr;
        }

        int mini = Integer.MAX_VALUE;
        for(int i=0;i<triangle.size();i++)
        {
            mini = Math.min(mini,prev[i]); 
        }

        return mini;
    }
}