class DisjointSet
{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n)
    {
        for(int i=0;i<=n;i++)
        {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node)
    {
        if(node==parent.get(node))
        {
            return node;
        }

        int ulp = findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }

    public void unionByRank(int u,int v)
    {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u==ulp_v)
        {
            return;
        }

        if(rank.get(ulp_u) < rank.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u))
        {
            parent.set(ulp_v,ulp_u);
        }
        else
        {
            int uRank = rank.get(ulp_u);
            rank.set(ulp_u,uRank+1);
            parent.set(ulp_v,ulp_u);
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);

        int extraEdge = 0;
        for(int[] edge : connections)
        {
            int u = edge[0];
            int v = edge[1];

            if(ds.findUPar(u)==ds.findUPar(v))
            {
                extraEdge++;
            }
            else
            {
                ds.unionByRank(u,v);
            }
        }

        int components = 0;
        for(int i=0;i<n;i++)
        {
            if(ds.parent.get(i)==i)
            {
                components++;
            }
        }

        int ans = components - 1;
        if(extraEdge>=components-1)
        {
            return ans;
        }

        return -1;
    }
}