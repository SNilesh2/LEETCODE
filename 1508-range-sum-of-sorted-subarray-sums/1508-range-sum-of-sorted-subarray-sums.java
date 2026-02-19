class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Long> list=new ArrayList<>();
        int mod=1000000007;
        long sum=0;
        for(int i=0;i<n;i++)
        {
            list.add((long)nums[i]);
            sum=nums[i];
            for(int j=i+1;j<n;j++)
            {
                sum=sum+nums[j];
                list.add(sum);
            }
        }

        Collections.sort(list);

        long result=0;
        for(int i=left;i<=right;i++)
        {
            result=result + list.get(i-1);
        }
        return (int)(result % mod);
    }
}