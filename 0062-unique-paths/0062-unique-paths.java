class Solution {
    public int uniquePaths(int m, int n) {
        return findUniquePaths(m,n);
    }
    public int findUniquePaths(int r,int c)
    {
        int[] prev = new int[c];
        Arrays.fill(prev,1);

        for(int i=1;i<r;i++)
        {
            int[] curr = new int[c];
            for(int j=0;j<c;j++)
            {

                int top = prev[j];

                int left = 0;

                if(j-1 >= 0)
                {
                    left = curr[j-1];
                }

                curr[j] = top + left;
            }
            prev = curr;
        }

        return prev[c-1];
    }
}