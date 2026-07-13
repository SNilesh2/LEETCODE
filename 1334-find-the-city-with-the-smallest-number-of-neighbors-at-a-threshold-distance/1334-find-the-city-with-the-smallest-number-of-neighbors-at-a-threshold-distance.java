class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adjMat = new int[n][n];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                {
                    adjMat[i][j] = 0;
                }          
                else
                {
                    adjMat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adjMat[u][v] = wt;
            adjMat[v][u] = wt;
        }

        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(adjMat[i][k]!=Integer.MAX_VALUE && adjMat[k][j]!=Integer.MAX_VALUE)
                    {
                        adjMat[i][j] = Math.min(adjMat[i][j],adjMat[i][k] + adjMat[k][j]);
                    }
                }
            }
        }

        int minCity = n;
        int result = -1;
        for(int i=0;i<n;i++)
        {
            int count = 0;
            for(int j=0;j<n;j++)
            {
                if(adjMat[i][j]<=distanceThreshold)
                {
                    count++;
                }
            }
            if(count<=minCity)
            {
                result = i;
                minCity = count;
            }
        }

        return result;
    }
}