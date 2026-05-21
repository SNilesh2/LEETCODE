class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<nums.length;i++)
        {
            String s = String.valueOf(nums[i]);

            for(int j=0;j<s.length();j++)
            {
                list.add(s.charAt(j) - '0');
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