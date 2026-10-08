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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        int carry = 0;
        ListNode prev = null;
        ListNode head = null;
        while(temp1!=null && temp2!=null)
        {
            int sum = temp1.val + temp2.val + carry;

            carry = (sum > 9) ? 1 : 0;
            sum = sum % 10;

            ListNode nn = new ListNode(sum);

            if(prev==null)
            {
                head = nn;
                prev = nn;
            }
            else
            {
                prev.next = nn;
                prev = nn;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while(temp1!=null)
        {
            int sum = temp1.val + carry;
            carry = (sum > 9) ? 1 : 0;
            sum = sum % 10;

            ListNode nn = new ListNode(sum);
            prev.next = nn;
            prev = nn;

            temp1 = temp1.next;
        }



        while(temp2!=null)
        {
            int sum = temp2.val + carry;
            carry = (sum > 9) ? 1 : 0;
            sum = sum % 10;

            ListNode nn = new ListNode(sum);
            prev.next = nn;
            prev = nn;

            temp2 = temp2.next;
        }

        if(carry > 0)
        {
            ListNode nn = new ListNode(carry);
            prev.next = nn;
        }

        return head;
    }
}