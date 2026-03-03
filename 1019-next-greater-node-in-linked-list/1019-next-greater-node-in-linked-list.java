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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp=head;
        int count=0;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        ListNode revHead=reverse(head);
        Stack<Integer> st=new Stack<>();
        int[] res=new int[count];

        int i=count-1;
        st.push(revHead.val);
        res[i]=0;

        temp=revHead.next;
        while(temp!=null)
        {
            if(temp.val < st.peek())
            {
                res[--i]=st.peek();
                st.push(temp.val);
            }
            else
            {
                while(!st.isEmpty() && temp.val >= st.peek())
                {
                    st.pop();
                }

                if(st.isEmpty())
                {
                    res[--i]=0;
                }
                else
                {
                    res[--i]=st.peek();
                }
                st.push(temp.val);
            }
            temp=temp.next;
        }
        return res;
    }
    public static ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode temp=head;
        ListNode Next=null;

        while(temp!=null)
        {
            Next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=Next;
        }
        return prev;
    }
}