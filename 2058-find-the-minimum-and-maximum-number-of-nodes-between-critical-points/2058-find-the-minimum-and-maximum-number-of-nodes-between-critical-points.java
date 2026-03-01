/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp=head;
        ArrayList<Integer> list=new ArrayList<>();
        ListNode prev=null;
        int[] result=new int[2];
        int ind=1;
        while(temp!=null)
        {
            if(prev!=null && temp.next!=null)
            {
                if(temp.val>prev.val && temp.val>temp.next.val)
                {
                    list.add(ind);
                }
                else if(temp.val<prev.val && temp.val<temp.next.val)
                {
                    list.add(ind);
                }
            }
            ind++;
            prev=temp;
            temp=temp.next;
        }

        if(list.size()<2)
        {
            result[0]=-1;
            result[1]=-1;
            return result;
        }

        result[1]=list.get(list.size()-1) - list.get(0);
        int mini=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++)
        {
            mini=Math.min(mini,(list.get(i) - list.get(i-1)));
        }
        result[0]=mini;
        return result;
    }
}