class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites)
        {
            adjList.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }

        ArrayList<Integer> topoSort = new ArrayList<>();
        while(!q.isEmpty())
        {
            int node = q.poll();
            topoSort.add(node);

            for(int neighbour : adjList.get(node))
            {
                indegree[neighbour]--;
                if(indegree[neighbour]==0)
                {
                    q.add(neighbour);
                }
            }
        }

        if(numCourses != topoSort.size())
        {
            return new int[]{};
        }

        Collections.reverse(topoSort);
        int[] result = new int[numCourses];
        for(int i=0;i<topoSort.size();i++)
        {
            result[i] = topoSort.get(i);
        }

        return result;
    }
}