class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();

        for(String word : words)
        {
            int sum = 0;
            for(int i=0;i<word.length();i++)
            {
                int ind = word.charAt(i) - 'a';
                sum = sum + weights[ind];
            }
            int mod = sum % 26;
            char c = (char) ('z' - mod);
            sb.append(c);
        }

        return sb.toString();
    }
}