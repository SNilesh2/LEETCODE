class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        if(numRows==0)
        {
            return result;
        }
        for(int row=1;row<=numRows;row++)
        {
            result.add(generaterow(row));
        }
        return result;
    }
    public List<Integer> generaterow(int n)
    {
        int ans=1;
        List<Integer> ansrow=new ArrayList<>();
        ansrow.add(1);
        for(int col=1;col<n;col++)
        {
            ans=ans*(n-col);
            ans=ans/col;
            ansrow.add(ans);
        }
        return ansrow;
    }
}