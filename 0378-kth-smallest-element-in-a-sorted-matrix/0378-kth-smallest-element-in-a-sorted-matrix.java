class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int low=matrix[0][0];
        int high=matrix[n-1][n-1];

        while(low<high)
        {
            int mid=low+(high-low)/2;

            if(count(matrix,mid)<k)
            {
                low=mid+1;
            }
            else
            {
                high=mid;
            }
        }
        return low;
    }
    public static int count(int[][] matrix,int val)
    {
        int n=matrix.length;
        int row=n-1;
        int answer=0;
        int col=0;

        while(row>=0 && col<n)
        {
            if(matrix[row][col]<=val)
            {
                answer=answer+(row+1);
                col++;
            }
            else
            {
                row--;
            }
        }

        return answer;
    }
}