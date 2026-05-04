class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<gifts.length;i++)
        {
            pq.offer(gifts[i]);
        }

        for(int i=0;i<k;i++)
        {
            int max = pq.poll();

            int val = (int)Math.sqrt(max);

            pq.offer(val);
        }

        long result = 0;
        while(!pq.isEmpty())
        {
            result = result + pq.poll();
        }

        return result;
    }
}