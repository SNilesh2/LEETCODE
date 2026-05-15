class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();

        int goalNode = graph.length-1;

        Queue<List<Integer>> q = new LinkedList<>();

        q.add(Arrays.asList(0));

        while (!q.isEmpty()) {
            List<Integer> path = q.poll();

            int lastVal = path.get(path.size() - 1);

            if (lastVal == goalNode) {
                result.add(path);
            } else {
                int[] neighbour = graph[lastVal];

                for (int val : neighbour) {
                    List<Integer> temp = new ArrayList<>(path);
                    temp.add(val);
                    q.add(temp);
                }
            }
        }
        return result;
    }
}