class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m+1][n+1];
        for(int[] arr : memo)
        {
            Arrays.fill(arr,-1);
        }
        return helper(m,n,memo);
    }

    public static int helper(int m,int n,int[][] memo)
    {
        if(memo[m][n]!=-1)
        {
            return memo[m][n];
        }

        if(m==1 && n==1)
        {
            return 1;
        }

        if(m==0 || n==0)
        {
            return 0;
        }

        return memo[m][n] = helper(m-1,n,memo) + helper(m,n-1,memo);
    }
}