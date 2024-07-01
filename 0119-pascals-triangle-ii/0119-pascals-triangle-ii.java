class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<>();
        if(rowIndex<0)
        {
            return res;
        }
        long ans=1;
        res.add(1);
        for(int col=1;col<=rowIndex;col++)
        {
            ans=ans*(rowIndex+1-col);
            ans=ans/(col);
            res.add((int)ans);
        }
        return res;
    }
}