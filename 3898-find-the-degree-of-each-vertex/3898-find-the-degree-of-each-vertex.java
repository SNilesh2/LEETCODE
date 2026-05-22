class Solution {
    public int[] findDegrees(int[][] matrix) {
        int[] answer = new int[matrix.length];

        for(int i=0;i<matrix.length;i++)
        {
            int count = 0;
            for(int j=0;j<matrix.length;j++)
            {
                if(matrix[i][j] != 0)
                {
                    count++;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}