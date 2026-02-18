class Solution {
    public String lexSmallest(String s) {
        int n = s.length();

        String result = null;

        for (int i = 1; i < n; i++) {
            String smallestFirstK = reverse(s, 0, i);
            String smallestLastK = reverse(s, i, n - 1);

            if (result == null || smallestFirstK.compareTo(result) < 0) {
                result = smallestFirstK;
            }
            if (smallestLastK.compareTo(result) < 0) {
                result = smallestLastK;
            }

        }
        if(result==null)
        {
            return s;
        }
        return result;
    }

    public static String reverse(String s, int start, int end) {

        char[] array = s.toCharArray();

        while (start <= end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }

        return new String(array);
    }
}