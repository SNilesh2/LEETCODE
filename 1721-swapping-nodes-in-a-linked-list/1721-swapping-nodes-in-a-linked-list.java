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
    public ListNode swapNodes(ListNode head, int k) {
        int FirstK=k;
        ListNode temp=head;
        int count=0;
        while(temp!=null)
        {
            temp=temp.next;
            count++;
        }
        int LastK= (count - k) + 1;
        temp=head;
        int ind=1;
        ListNode start=null;
        ListNode end=null;
        int startVal=-1;
        int endVal=-1;
        while(temp!=null)
        {
            if(ind==FirstK)
            {
                start=temp;
            }
            if(ind==LastK)
            {
                end=temp;
            }
            temp=temp.next;
            ind++;
        }
        int tempVal=start.val;
        start.val=end.val;
        end.val=tempVal;
        return head;
    }
}