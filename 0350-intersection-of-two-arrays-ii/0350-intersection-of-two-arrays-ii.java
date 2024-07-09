class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        for(int num:nums1)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:nums2)
        {
            if(map.getOrDefault(num,0)>0)
            {
                ans.add(num);
                map.put(num,map.getOrDefault(num,0)-1);
            }
        }
        int[] res=new int[ans.size()];
        int i=0;
        for(int num:ans)
        {
            res[i]=num;
            i++;
        }
        return res;
    }
}