class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> romanvalues=new HashMap<>();
        romanvalues.put('I',1);
        romanvalues.put('V',5);
        romanvalues.put('X',10);
        romanvalues.put('L',50);
        romanvalues.put('C',100);
        romanvalues.put('D',500);
        romanvalues.put('M',1000);
        int total=0;
        int prevvalue=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            int currentvalue=romanvalues.get(s.charAt(i));
            if(currentvalue<prevvalue)
            {
                total=total-currentvalue;
            }
            else
            {
                total=total+currentvalue;
            }
            prevvalue=currentvalue;
        }
        return total;
    }
}