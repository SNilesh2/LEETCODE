class Solution {
    public int[] numberGame(int[] nums) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
        }

        int[] result = new int[nums.length];
        int ind = 0;
        while(!pq.isEmpty())
        {
            int alice = pq.poll();
            int bob = pq.poll();

            result[ind++] = bob;
            result[ind++] = alice;
        }

        return result;
    }
}