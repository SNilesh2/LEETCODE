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


    public void UnionByRank(int u,int v)
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
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1)
                {
                    ds.UnionByRank(i,j);
                }
            }
        }

        int result = 0;
        for(int i=0;i<n;i++)
        {
            if(ds.parent.get(i) == i)
            {
                result++;
            }
        }

        return result;
    }
}