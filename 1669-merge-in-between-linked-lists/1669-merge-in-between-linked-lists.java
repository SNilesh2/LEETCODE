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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2)   
    {
        ListNode temp=list1;
        ListNode last=null;
        ListNode start=null;
        
        for(int i=0;i<a;i++)
        {
            if(i==a-1)
            {
                last=temp;
                break;
            }
            temp=temp.next;
        }
        
        ListNode curr=last;
        for(int i=0;i<b-a+1;i++)
        {
            curr=curr.next;
        }
        start=curr.next;


        temp=list2;
        while(temp.next!=null)
        {
            temp=temp.next;
        }

        ListNode list2Last=temp;

        last.next=list2;
        list2Last.next=start;

        return list1;
    }
}