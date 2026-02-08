class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int row=mat.length;
        int col=mat[0].length;
        int low=0;
        int high=Math.min(row,col);                 

        int maxi=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;

            if(isPossible(mat,mid,threshold))
            {
                maxi=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        System.out.println(maxi);
        if(maxi==0)
        {
            return 0;
        }
        return maxi;
    }

    public static boolean isPossible(int[][] matrix,int size,int threshold)
    {
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<=row-size;i++)
        {
            for(int j=0;j<=col-size;j++)
            {
                int startRow=i;
                int startCol=j;

                int sum=0;
                for(int k=startRow;k<startRow+size;k++)
                {
                    for(int l=startCol;l<startCol+size;l++)
                    {
                        sum=sum + matrix[k][l];
                    }
                }
                if(sum<=threshold)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static int count(int maxi,int[][] matrix,int threshold)
    {
        int row=matrix.length;
        int col=matrix[0].length;
        int count=0;
        for(int i=0;i<=row-maxi;i++)
        {
            for(int j=0;j<=col-maxi;j++)
            {
                int startRow=i;
                int startCol=j;
                int sum=0;

                for(int k=startRow;k<startRow+maxi;k++)
                {
                    for(int l=startCol;l<startCol+maxi;l++)
                    {
                        sum=sum + matrix[k][l];
                    }
                }
                if(sum<=threshold)
                {
                    count++;
                }
            }
        }
        return count;
    }
}