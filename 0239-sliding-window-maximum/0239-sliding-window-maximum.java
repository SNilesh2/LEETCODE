class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < k)
        {
            return new int[]{};
        }
        Deque<Integer> dq = new ArrayDeque<>(); //storing index
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<nums.length;i++)
        {
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
            {
                dq.pollLast();
            }
            
            dq.offerLast(i);

            while(!dq.isEmpty() && dq.peekFirst() < i + 1 - k)
            {
                dq.pollFirst();
            }

            if(i >= k-1)
            {
                list.add(nums[dq.peekFirst()]);
            }
        }

        int[] result = new int[list.size()];

        for(int i=0;i<list.size();i++)
        {
            result[i] = list.get(i);
        }

        return result;
    }
}