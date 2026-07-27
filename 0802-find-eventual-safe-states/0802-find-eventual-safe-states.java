class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> revAdjList = new ArrayList<>();

        for(int i=0;i<V;i++)
        {
            revAdjList.add(new ArrayList<>());
        }

        //making the reverse graph
        int[] indegree = new int[V];
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                int u = i;
                int v = graph[i][j];

                revAdjList.get(v).add(u);
                indegree[u]++;
            }
        }

        //enqueue the nodes which has the indegree 0
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }

        //finding the safe nodes by backtrack from the terminal nodes which has a indegree 0
        List<Integer> safeNodes = new ArrayList<>();
        while(!q.isEmpty())
        {
            int node = q.poll();
            safeNodes.add(node);

            for(int neighbour : revAdjList.get(node))
            {
                indegree[neighbour]--;

                if(indegree[neighbour]==0)
                {
                    q.add(neighbour);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}