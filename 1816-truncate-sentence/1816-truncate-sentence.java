class Solution {
    public String truncateSentence(String s, int k) {
        String[] strArr = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<k;i++)
        {
            sb.append(strArr[i]);

            if(i!=k-1)
            {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}