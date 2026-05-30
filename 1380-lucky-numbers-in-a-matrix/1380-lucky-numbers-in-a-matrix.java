class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0;i<row;i++)
        {
            int minInd = -1;
            int minEle = Integer.MAX_VALUE;
            for(int j=0;j<col;j++)
            {
                if(matrix[i][j]<minEle)
                {
                    minEle = matrix[i][j];
                    minInd = j;
                }
            }

            //search this minimum element is the maximum in its column 
            int k;
            for(k=0;k<row;k++)
            {
                if(matrix[k][minInd] > minEle)
                {
                    break;
                }
            }

            if(k==row)
            {
                result.add(minEle);
            }
        }

        return result;
    }
}