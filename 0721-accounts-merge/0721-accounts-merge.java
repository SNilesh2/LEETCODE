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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                if(map.containsKey(accounts.get(i).get(j))==false)
                {
                    map.put(accounts.get(i).get(j),i);
                }
                else
                {
                    ds.unionByRank(i,map.get(accounts.get(i).get(j)));
                }
            }
        }

        List<List<String>> mergeMail = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            mergeMail.add(new ArrayList<>());
        }

        for(Map.Entry<String,Integer> en : map.entrySet())
        {
            int ulp = ds.findUPar(en.getValue());
            mergeMail.get(ulp).add(en.getKey());
        }

        List<List<String>> result = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(mergeMail.get(i).size()==0)
            {
                continue;
            }

            Collections.sort(mergeMail.get(i));
            ArrayList<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String mail : mergeMail.get(i))
            {
                temp.add(mail);
            }
            result.add(temp);
        }

        return result;
    }
}