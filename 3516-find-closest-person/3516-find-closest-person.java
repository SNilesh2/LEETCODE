class Solution {
    public int findClosest(int x, int y, int z) {
        int XZ = Math.abs(x-z);
        int YZ = Math.abs(y-z);

        if(XZ < YZ)
        {
            return 1;
        } 
        else if(XZ > YZ)
        {
            return 2;
        }

        return 0;
    }
}