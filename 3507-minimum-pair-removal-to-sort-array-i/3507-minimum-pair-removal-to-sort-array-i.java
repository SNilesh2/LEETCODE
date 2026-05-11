class Solution {
    public int minimumPairRemoval(int[] nums) {
        int operations = 0;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            list.add(nums[i]);
        }

        while(!isSorted(list))
        {
            int minSum = Integer.MAX_VALUE;
            int index = 0;
            for(int i=0;i<list.size()-1;i++)
            {
                if(list.get(i) + list.get(i+1) < minSum)
                {
                    minSum = list.get(i) + list.get(i+1);
                    index = i;
                }
            }

            list.set(index,minSum);
            list.remove(index+1);

            operations++;
        }
        return operations;
    }
    public static boolean isSorted(ArrayList<Integer> arr)
    {
        for(int i=0;i<arr.size()-1;i++)
        {
            if(arr.get(i) > arr.get(i+1))
            {
                return false;
            }
        }
        return true;
    }
}