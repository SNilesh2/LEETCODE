class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList)   
    {
        
        int p1=0;
        int p2=0;
        int firstLen=firstList.length;
        int secondLen=secondList.length;

        if(firstLen==0 || secondLen==0)
        {
            return new int[][]{};
        }

        ArrayList<int[]> result=new ArrayList<>();
        while(p1<firstLen && p2<secondLen)
        {
            int firstVal1=firstList[p1][0];
            int firstVal2=firstList[p1][1];
            int secondVal1=secondList[p2][0];
            int secondVal2=secondList[p2][1];

            if(firstVal1>=secondVal1 && firstVal1<=secondVal2)
            {
                int[] temp=new int[2];
                temp[0]=firstVal1;
                if(firstVal2<secondVal2)
                {
                    temp[1]=firstVal2;
                    p1++;
                }
                else
                {
                    temp[1]=secondVal2;
                    p2++;
                }
                result.add(temp);
            }
            else if(secondVal1>=firstVal1 && secondVal1<=firstVal2)
            {
                int[] temp=new int[2];
                temp[0]=secondVal1;
                if(firstVal2<secondVal2)
                {
                    temp[1]=firstVal2;
                    p1++;
                }
                else
                {
                    temp[1]=secondVal2;
                    p2++;
                }
                result.add(temp);
            }
            else
            {
                if(firstVal2<secondVal1)
                {
                    p1++;
                }
                else
                {
                    p2++;
                }
            }
        }

        int size=result.size();
        int[][] answer=new int[size][2];
        for(int i=0;i<size;i++)
        {
            answer[i]=result.get(i);
        }
        return answer;
    }
}