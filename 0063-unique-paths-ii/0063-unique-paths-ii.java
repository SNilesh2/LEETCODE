class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        return findPaths(m,n,obstacleGrid);
    }

    public int findPaths(int r,int c,int[][] grid)
    {
        int[] prev = new int[c];

        for(int i=0;i<r;i++)
        {
            int[] curr = new int[c];
            for(int j=0;j<c;j++)
            {
                if(i==0 && j==0)
                {
                    curr[0] = (grid[0][0]==0) ? 1 : 0;
                    continue;
                }

                int top = 0;
                if(i-1 >= 0)
                {
                    top = prev[j];
                }

                int left = 0;
                if(j-1 >= 0)
                {
                    left = curr[j-1];
                }

                curr[j] = (grid[i][j]==0) ? (top + left) : 0;
            }
            prev = curr;
        }

        return prev[c-1];
    }
}