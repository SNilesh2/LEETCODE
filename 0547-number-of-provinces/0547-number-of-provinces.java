class Solution {
    public int findCircleNum(int[][] isConnected) {
        int nodes = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<nodes;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<nodes;i++)
        {
            for(int j=0;j<nodes;j++)
            {
                if(isConnected[i][j]==1)
                {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int[] vis = new int[nodes];
        int provinces = 0;
        for(int i=0;i<nodes;i++)
        {
            if(vis[i]==0)
            {
                provinces++;
                dfs(i,adjList,vis);
            }
        }

        return provinces;
    }

    public static void dfs(int node,List<List<Integer>> adjList,int[] vis)
    {
        vis[node] = 1;

        for(int neighbour : adjList.get(node))
        {
            if(vis[neighbour]==0)
            {
                dfs(neighbour,adjList,vis);
            }
        }
    }
}