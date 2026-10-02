class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int maxf = 0;

        HashMap<Character,Integer> map = new HashMap<>();
        while(right < answerKey.length())
        {
            map.put(answerKey.charAt(right),map.getOrDefault(answerKey.charAt(right),0)+1);

            maxf = Math.max(maxf,map.get(answerKey.charAt(right)));

            int length = right - left + 1;

            if(length - maxf > k)
            {
                map.put(answerKey.charAt(left),map.get(answerKey.charAt(left))-1);
                left++;

                int maxi = 0;
                for(Map.Entry<Character,Integer> en : map.entrySet())
                {
                    maxi = Math.max(maxi,en.getValue());
                }

                maxf = maxi;
            }

            if(length - maxf <= k)
            {
                maxLength = Math.max(maxLength,length);
            }

            right++;
        }

        return maxLength;
    }
}