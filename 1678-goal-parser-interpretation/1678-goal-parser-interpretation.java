class Solution {
    public String interpret(String command) {

        StringBuilder sb = new StringBuilder();

        int i=0;
        while(i<command.length())
        {
            if(command.charAt(i)=='G')
            {
                sb.append("G");
                i++;
            }
            else if(command.charAt(i)=='(' && command.charAt(i+1)=='a')
            {
                sb.append("al");
                i = i + 4;
            }
            else
            {
                sb.append("o");
                i = i + 2;
            }
        }
        return sb.toString();
    }
}