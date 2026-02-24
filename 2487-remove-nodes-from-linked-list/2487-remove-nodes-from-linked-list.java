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
    public ListNode removeNodes(ListNode head) {
        head=reverse(head);
        int maxi=head.val;
        ListNode temp=head;
        while(temp.next!=null)
        {
            maxi=Math.max(maxi,temp.next.val);

            if(temp.next.val < maxi)
            {
                temp.next=temp.next.next;
                
            }
            else
            {
                temp=temp.next;
            }
        }
        return reverse(head);
    }
    public static ListNode reverse(ListNode head)
    {
        ListNode temp=head;
        ListNode Next=null;
        ListNode Prev=null;
        while(temp!=null)
        {
            Next=temp.next;
            temp.next=Prev;
            Prev=temp;
            temp=Next;
        }
        return Prev;
    }
}