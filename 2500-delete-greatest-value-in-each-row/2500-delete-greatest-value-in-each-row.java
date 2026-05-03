class Solution {
    public int deleteGreatestValue(int[][] grid) {
        List<PriorityQueue<Integer>>  list = new ArrayList<>();

        for(int i=0;i<grid.length;i++)
        {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int j=0;j<grid[0].length;j++)
            {
                pq.offer(grid[i][j]);
            }
            list.add(pq);
        }

        int result = 0;

        while(!list.get(0).isEmpty())
        {
            int maxi = Integer.MIN_VALUE;

            for(int i=0;i<list.size();i++)
            {
                maxi = Math.max(maxi,list.get(i).poll());
            }
            result = result + maxi;
        }
        return result;
    }
}