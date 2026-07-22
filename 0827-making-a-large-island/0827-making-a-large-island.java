class DisjointSet
{
    int[] size,parent;

    public DisjointSet(int n)
    {
        size = new int[n+1];
        parent = new int[n+1];

        for(int i=0;i<=n;i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUPar(int node)
    {
        if(node==parent[node])
        {
            return node;
        }

        return parent[node] = findUPar(parent[node]);
    }

    public void unionBySize(int u,int v)
    {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u==ulp_v)
        {
            return;
        }

        if(size[ulp_u] < size[ulp_v])
        {
            parent[ulp_u] = ulp_v;
            size[ulp_v] = size[ulp_v] + size[ulp_u];
        }
        else
        {
            parent[ulp_v] = ulp_u;
            size[ulp_u] = size[ulp_u] + size[ulp_v];
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;

        DisjointSet ds = new DisjointSet(n * n);
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        //step 1 : use unionBySize() to join the nodes as components  
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    for(int k=0;k<4;k++)
                    {
                        int nr = i + drow[k];
                        int nc = j + dcol[k];

                        if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==1)
                        {
                            int u = (i * n) + j;
                            int v = (nr * n) + nc;
                            if(ds.findUPar(u)!=ds.findUPar(v))
                            {
                                ds.unionBySize(u,v);
                            }
                        }
                    }
                }
            }
        }

        //step 2 : make each 0 cell to 1 and count the size of the components 

        int maxIsland = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    HashSet<Integer> set = new HashSet<>();
                    int count = 1;
                    for(int k=0;k<4;k++)
                    {
                        int nr = i + drow[k];
                        int nc = j + dcol[k];

                        if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==1)
                        {
                            int node = (nr * n) + nc;
                            set.add(ds.findUPar(node));
                        }
                    }

                    for(Integer parent : set)
                    {
                        count = count + ds.size[parent];
                    }

                    maxIsland = Math.max(maxIsland,count);
                }
            }
        }

        for(int i=0;i<n*n;i++)
        {
            maxIsland = Math.max(maxIsland,ds.size[i]);
        }
        return maxIsland;
    }
}