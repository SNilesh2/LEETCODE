class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];

        for(int[] arr : dp)
        {
            Arrays.fill(arr,-1);
        }

        int mini = Integer.MAX_VALUE;
        for(int i=0;i<triangle.get(size-1).size();i++)
        {
            mini = Math.min(mini, findMinTotal(size-1,i,triangle,dp));
        }

        return mini;
    }

    public int findMinTotal(int r,int c,List<List<Integer>> triangle,int[][] dp)
    {
        if(r==0 && c==0)
        {
            return triangle.get(0).get(0);
        }

        if(c<0 || c>=triangle.get(r).size())
        {
            return Integer.MAX_VALUE;
        }

        if(dp[r][c]!=-1)
        {
            return dp[r][c];
        }

        int upLeft = findMinTotal(r-1,c-1,triangle,dp);

        int upRight = findMinTotal(r-1,c,triangle,dp);

        return dp[r][c] = triangle.get(r).get(c) + Math.min(upLeft,upRight);
    }
}