class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder normalized=new StringBuilder();
        for(char c:s.toCharArray())
        {
            if(Character.isLetterOrDigit(c))
            {
                normalized.append(Character.toLowerCase(c));
            }
        }
        int left=0;
        int right=normalized.length()-1;
        while(left<right)
        {
            if(normalized.charAt(left)!=normalized.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}