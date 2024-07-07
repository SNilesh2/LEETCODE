class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int low=0,high=mat[0].length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int row=findmaxrow(mat,mid);
            int left=mid-1>=0 ? mat[row][mid-1]:-1;
            int right=mid+1<mat[0].length ? mat[row][mid+1]:-1;
            if(mat[row][mid]>left && mat[row][mid]>right) return new int[] {row,mid};
            else if(mat[row][mid]<left) high=mid-1;
            else low=mid+1;
        }
        return new int[] {-1,-1};
    }
    public static int findmaxrow(int[][] mat,int col)
    {
        int index=-1,maxvalue=Integer.MIN_VALUE;
        for(int i=0;i<mat.length;i++)
        {
            if(mat[i][col]>maxvalue)
            {
                maxvalue=mat[i][col];
                index=i;
            }
        }
        return index;
    }
}