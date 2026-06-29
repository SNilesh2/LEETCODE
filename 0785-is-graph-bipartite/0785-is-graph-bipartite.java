class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        Arrays.fill(color,-1);

        for(int i=0;i<graph.length;i++)
        {
            if(color[i]==-1)
            {
                if(dfs(graph,color,i,0)==false)
                {
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean dfs(int[][] graph,int[] color,int node,int col)
    {
        color[node] = col;

        for(int neighbour : graph[node])
        {
            if(color[neighbour]==-1)
            {
                int temp = (col==0) ? 1 : 0;

                if(dfs(graph,color,neighbour,temp)==false)
                {
                    return false;
                }
            }
            else
            {
                if(color[node]==color[neighbour])
                {
                    return false;
                }
            }
        }

        return true;
    }

}