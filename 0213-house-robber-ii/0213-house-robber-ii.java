class Solution {
    public int rob(int[] nums) {
        int size = nums.length;
        int[] arr1 = new int[size-1];
        int[] arr2 = new int[size-1];

        int j=0,k=0;
        for(int i=0;i<size;i++)
        {
            if(i!=0)
            {
                arr1[j++] = nums[i];
            }
            if(i!=size-1)
            {
                arr2[k++] = nums[i];
            }
        }

        if(nums.length==1)
        {
            return nums[0];
        }

        return Math.max(findMax(arr1),findMax(arr2));
    }

    public static int findMax(int[] nums)
    {

        int prev1 = nums[0];
        int prev2 = 0;

        for(int i=1;i<nums.length;i++)
        {
            int pick = nums[i];
            if(i-2 >= 0)
            {
                pick = pick + prev2;
            }
            int notpick = 0;
            if(i-1 >= 0)
            {
                notpick = prev1;
            }

            int curr = Math.max(pick,notpick);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}