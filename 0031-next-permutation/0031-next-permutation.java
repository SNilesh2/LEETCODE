class Solution {
    public void nextPermutation(int[] nums) {
        int ind=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                ind=i;
                break;
            }
        }
        if(ind==-1)
        {
           reverse(nums,0);
           return;
        }
        for(int i=n-1;i>ind;i--)
        {
            if(nums[i]>nums[ind])
            {
                int temp=nums[ind];
                nums[ind]=nums[i];
                nums[i]=temp;
                break;
            }
        }
        reverse(nums,ind+1);
    }
    public void reverse(int nums[],int start)
    {
        int end=nums.length-1;
        while(start<end)
        {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}