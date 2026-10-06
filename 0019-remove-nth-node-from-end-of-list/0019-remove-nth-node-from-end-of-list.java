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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        
        int length = 0;
        while(temp!=null)
        {
            temp = temp.next;
            length++;
        }

        temp = null;
        for(int i=0;i<length-n;i++)
        {
            if(temp == null)
            {
                temp = head;
            }
            else
            {
                temp = temp.next;
            }
        }

        if(temp==null)
        {
            return head.next;
        }

        temp.next = temp.next.next;
        
        return head;
    }
}