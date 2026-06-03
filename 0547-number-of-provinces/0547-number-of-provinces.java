class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();

        int row = isConnected.length;
        int col = isConnected[0].length;
        for(int i=0;i<row;i++)
        {
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<col;j++)
            {
                if(i!=j && isConnected[i][j]==1)
                {
                    temp.add(j);
                }
            }
            adjList.add(temp);
        }

        int result = 0;

        int[] vis = new int[row];
        for(int i=0;i<row;i++)
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