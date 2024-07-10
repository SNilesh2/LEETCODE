class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set=new HashSet<>();
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int num:nums)
        {
            if(!set.contains(num))
            {
                set.add(num);
                q.offer(num);
                if(q.size()>3) q.poll();
            }
        }
        if(q.size()==3) return q.peek();
        else 
        {
            while(q.size()>1) q.poll();
            return q.peek();
        }
    }
}