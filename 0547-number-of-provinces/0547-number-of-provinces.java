class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1)
                {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int[] vis = new int[n];
        int result = 0;
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                result++;
                dfs(i,vis,adjList);
            }
        }

        return result;
    }

    public static void dfs(int node,int[] vis,List<List<Integer>> adjList)
    {
        vis[node] = 1;

        for(int neighbour : adjList.get(node))
        {
            if(vis[neighbour]==0)
            {
                dfs(neighbour,vis,adjList);
            }
        }
    }
}