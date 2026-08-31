class Solution {
    public List<String> cellsInRange(String s) {
        String[] str = s.split(":");
        int row = (str[1].charAt(1) - '0') - (str[0].charAt(1) - '0') + 1;
        int col = str[1].charAt(0) - str[0].charAt(0) + 1;

        List<String> result = new ArrayList<>();
        for(int i=0;i<col;i++)
        {
            char letter = (char)(str[0].charAt(0) + i);
            for(int j=0;j<row;j++)
            {
                StringBuilder sb = new StringBuilder();
                sb.append(letter);
                sb.append((char)(str[0].charAt(1) + j));

                result.add(sb.toString());
            }
        }

        return result;
    }
}