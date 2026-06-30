class Solution {
    public String reverseByType(String s) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='a' && s.charAt(i)<='z')
            {
                sb1.append(s.charAt(i));
            }
            else
            {
                sb2.append(s.charAt(i));
            }
        } 

        sb1 = sb1.reverse();
        sb2 = sb2.reverse();

        int ptr1 = 0;
        int ptr2 = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='a' && s.charAt(i)<='z')
            {
                result.append(sb1.charAt(ptr1++));
            }
            else
            {
                result.append(sb2.charAt(ptr2++));
            }
        } 

        return result.toString();
    }
}