class FindSumPairs {
            int nums1[];
            int nums2[];
            HashMap<Integer,Integer> h2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2; 
        this.h2  = new HashMap<>();
        for(int j : nums2)
        {
            h2.put(j,h2.getOrDefault(j,0)+1);
        }
        
    }
    
    public void add(int index, int val) {
        int old = nums2[index];
        int n = old + val;
        h2.put(old,h2.get(old)-1);
        if(h2.get(old) == 0)  h2.remove(old);
        h2.put(n,h2.getOrDefault(n,0) + 1);
        nums2[index] = n;
    }
    
    public int count(int tot) {
        HashMap<Integer,Integer> h1 = new HashMap<>();
        
        for(int i : nums1)
        {
            h1.put(i,h1.getOrDefault(i,0)+1);
        }
        
        int count = 0;
        for(int k : h1.keySet())
        {
            if(h2.containsKey(tot-k))
            {
                count += h1.get(k) * h2.get(tot-k);;
            }
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */