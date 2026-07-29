class DisjointSet
{
    int[] rank;
    int[] parent;
    
    public DisjointSet(int n)
    {
        rank = new int[n+1];
        parent = new int[n+1];

        for(int i=0;i<=n;i++)
        {
            rank[i] = 1;
            parent[i] = i;
        }
    }

    public int findUPar(int node)
    {
        if(node==parent[node])
        {
            return node;
        }

        int ulp = findUPar(parent[node]);
        return parent[node] = ulp;
    }

    public void unionByRank(int u,int v)
    {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u==ulp_v)
        {
            return;
        }

        if(rank[ulp_u] < rank[ulp_v])
        {
            parent[ulp_u] = ulp_v;
        }
        else if(rank[ulp_v] < rank[ulp_u])
        {
            parent[ulp_v] = ulp_u;
        }
        else
        {
            int uRank = rank[ulp_u];
            rank[ulp_u] = uRank + 1;
            parent[ulp_v] = ulp_u;
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;

        int maxRow = 0;
        int maxCol = 0;
        for(int i=0;i<n;i++)
        {
            maxRow = Math.max(maxRow,stones[i][0]);
            maxCol = Math.max(maxCol,stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);

        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            int u = stones[i][0];
            int v = stones[i][1] + maxRow + 1;

            ds.unionByRank(u,v);
            set.add(u);
            set.add(v);
        }

        int cnt = 0;
        for(int node : set)
        {
            if(node == ds.findUPar(node))
            {
                cnt++;
            }
        }

        //number of total nodes - no of connected components
        return n - cnt;
    }
}