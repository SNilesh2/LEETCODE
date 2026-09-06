class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return findMinPath(m,n,grid);
    }

    public int findMinPath(int r,int c,int[][] grid)
    {
        int[] prev = new int[c];
        Arrays.fill(prev,Integer.MAX_VALUE);

        for(int i=0;i<r;i++)
        {
            int[] curr = new int[c];
            for(int j=0;j<c;j++)
            {
                if(i==0 && j==0)
                {
                    curr[0] = grid[0][0];
                    continue;
                }

                int top = prev[j];

                int left = Integer.MAX_VALUE;
                if(j-1 >= 0)
                {
                    left = curr[j-1];
                }

                curr[j] = Math.min(top,left) + grid[i][j];
            }
            prev = curr;
        }

        return prev[c-1];
    }
}