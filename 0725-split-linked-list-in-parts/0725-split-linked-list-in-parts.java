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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int total=0;
        ListNode temp=head;
        while(temp!=null)
        {
            total++;
            temp=temp.next;
        }

        int split=total/k;
        int extra=total % k;
        ListNode[] result=new ListNode[k];
        temp=head;
        ListNode Next=null;
        for(int i=0;i<k;i++)
        {
            if(temp==null)
            {
                result[i]=null;
                continue;
            }
            result[i]=temp;

            int nodesToAdd=split + ((extra>0) ? 1 : 0);
            extra--;

            
            int count=1;
            while(count<nodesToAdd)
            {
                temp=temp.next;
                count++;
            }
            Next=temp.next;
            temp.next=null;
            temp=Next;
        }
        return result;
    }
}