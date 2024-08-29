class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++)
        {
            if(color[i]==-1)
            {
                if(check(graph,color,i)==false) return false;
            }
        }
        return true;
    }
    public static boolean check(int[][] graph,int[] color,int start)
    {
        Queue<Integer> q=new LinkedList<>();
        color[start]=0;
        q.add(start);
        while(!q.isEmpty())
        {
            int node=q.poll();
            for(int it:graph[node])
            {
                if(color[it]==-1)
                {
                    color[it]=1-color[node];
                    q.add(it);
                }
                else if(color[it]==color[node])
                {
                    return false;
                }
            }
        }
        return true;
    }
}