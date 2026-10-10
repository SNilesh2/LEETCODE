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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode passHead = head;
        ListNode prevTail = null;
        int count = 1;
        while(temp!=null)
        {
            if(count%k == 0)
            {
                ListNode nextHead = temp.next;
                temp.next = null;
                ListNode reverseHead = reverse(passHead);
                if(count==k)
                {
                    head = reverseHead;
                }
                else
                {
                    prevTail.next = reverseHead;
                }

                prevTail = passHead;
                passHead.next = nextHead;
                passHead = nextHead;
                temp = nextHead;
                count++;
            }
            else
            {
                temp = temp.next;
                count++;
            }
        }

        return head;
    }
    public static ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode temp = head;

        while(temp!=null)
        {
            ListNode nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }

        return prev;
    }
}