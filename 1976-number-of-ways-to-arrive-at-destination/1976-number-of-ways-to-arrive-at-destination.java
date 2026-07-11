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
class Tuple
{
    long distance;
    int node;
    public Tuple(long distance,int node)
    {
        this.distance = distance;
        this.node = node;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = (int)(1e9+7);
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int[] road  :roads)
        {
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            adjList.get(u).add(new Pair(v,wt));
            adjList.get(v).add(new Pair(u,wt));
        }

        long[] dis = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dis,Long.MAX_VALUE);
        dis[0] = 0;
        ways[0] = 1;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->Long.compare(a.distance,b.distance));

        pq.add(new Tuple(0,0));

        while(!pq.isEmpty())
        {
            Tuple t = pq.poll();
            long distance = t.distance;
            int node = t.node;
            
            for(Pair neighbour : adjList.get(node))
            {
                int v = neighbour.v;
                int wt = neighbour.wt;

                if(distance + wt < dis[v])
                {
                    dis[v] = distance + wt;
                    pq.add(new Tuple(distance+wt,v));
                    ways[v] = ways[node] % MOD;
                }
                else if(distance + wt == dis[v])
                {
                    ways[v] = (ways[v] + ways[node]) % MOD;
                }
            }
        }
        return ways[n-1] % MOD;
    }
}