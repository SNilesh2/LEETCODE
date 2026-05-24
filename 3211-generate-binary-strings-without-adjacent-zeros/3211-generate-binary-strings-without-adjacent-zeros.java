class Solution {
    public List<String> validStrings(int n) {
        int i=0;

        List<String> result = new ArrayList<>();

        while(i <= Math.pow(2,n) - 1)
        {
            String binaryStr = String.format("%" + n + "s",Integer.toBinaryString(i)).replace(' ','0');
            int j;
            for(j=1;j<binaryStr.length();j++)
            {
                if(binaryStr.charAt(j-1) != '1' && binaryStr.charAt(j) != '1')
                {
                    break;
                }
            }
            if(j == binaryStr.length())
            {
                result.add(binaryStr);
            }
            i++;
        }
        return result;
    }
}