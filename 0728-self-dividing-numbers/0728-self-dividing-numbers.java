class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int i=left;i<=right;i++)
        {
            int original = i;
            int num = i;

            while(num > 0)
            {
                int last = num % 10;
                if(last==0)
                {
                    break;
                }
                
                if(original % last == 0)
                {
                    num = num / 10;
                }
                else
                {
                    break;
                }
            }

            if(num == 0)
            {
                result.add(original);
            }
        }

        return result;
    }
}