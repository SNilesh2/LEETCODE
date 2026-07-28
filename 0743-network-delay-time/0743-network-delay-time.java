class Pair
{
    int v;
    int wt;
    public Pair(int v,int wt)
    {
        this.v = v;
        this.wt = wt;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adjList = new ArrayList<>();

        for(int i=0;i<=n;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int[] time : times)
        {
            int u = time[0];
            int v = time[1];
            int wt = time[2];

            adjList.get(u).add(new Pair(v,wt));
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(k,0));

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;

        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int node = p.v;
            int weight = p.wt;

            for(Pair neighbour : adjList.get(node))
            {
                int v = neighbour.v;
                int wt= neighbour.wt;

                if(weight + wt < dist[v])
                {
                    dist[v] = weight + wt;
                    q.add(new Pair(v,weight+wt));
                }
            }
        }

        int maxi = -1;
        for(int i=1;i<=n;i++)
        {
            maxi = Math.max(maxi,dist[i]);
        }
        
        if(maxi==Integer.MAX_VALUE)
        {
            return -1;
        }

        return maxi;
    }
}