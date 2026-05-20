class Solution {
    public int mostWordsFound(String[] sentences) {

        int maxi = 0;

        for(String s : sentences)
        {
            String[] strArr = s.split(" ");

            maxi = Math.max(maxi,strArr.length);
        }

        return maxi;
    }
}