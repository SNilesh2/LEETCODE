class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int Lcount = 0;
        int Rcount = 0;
        int _count = 0;

        for(int i=0;i<moves.length();i++)
        {
            if(moves.charAt(i)=='L')
            {
                Lcount++;
            }
            else if(moves.charAt(i)=='R')
            {
                Rcount++;
            }
            else
            {
                _count++;
            }
        }

        return Math.abs(Lcount-Rcount) + _count;
    }
}