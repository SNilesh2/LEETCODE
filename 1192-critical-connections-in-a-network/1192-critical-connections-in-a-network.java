class Solution {
    private int timer =1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<connections.size();i++)
        {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int[] vis = new int[n];
        int[] tim = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();

        dfs(0,-1,vis,tim,low,adjList,bridges);

        return bridges;
    }

    public void dfs(int node,int parent,int[] vis,int[] tim,int[] low,List<List<Integer>> adjList,List<List<Integer>> bridges)
    {
        vis[node] = 1;
        tim[node] = low[node] = timer;
        timer++;

        for(int neighbour : adjList.get(node))
        {
            if(neighbour==parent)
            {
                continue;
            }

            if(vis[neighbour]==0)
            {
                dfs(neighbour,node,vis,tim,low,adjList,bridges);

                low[node] = Math.min(low[node],low[neighbour]);

                if(low[neighbour] > tim[node])
                {
                    bridges.add(Arrays.asList(node,neighbour));
                }
            }
            else
            {
                low[node] = Math.min(low[node],low[neighbour]);
            }
        }
    }
}