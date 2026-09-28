class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i;
        for(i=n-1;i>0;i--)
        {
            if(nums[i-1] < nums[i])
            {
                int ind = findInd(nums,i,nums[i-1]);
                int temp = nums[i-1];
                nums[i-1] = nums[ind];
                nums[ind] = temp;

                reverse(nums,i,n-1);
                break;
            }
        }

        if(i==0)
        {
            reverse(nums,0,n-1);
        }
    }

    public int findInd(int[] nums,int ind,int val)
    {
        for(int i=nums.length-1;i>=ind;i--)
        {
            if(nums[i] > val)
            {
                return i;
            }
        }
        return -1;
    }
    public void reverse(int[] nums,int start,int end)
    {
        while(start<=end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}