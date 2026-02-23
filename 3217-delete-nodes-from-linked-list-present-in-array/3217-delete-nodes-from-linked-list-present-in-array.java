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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set=new HashSet<>();

        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            set.add(nums[i]);
        }

        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null)
        {
            if(set.contains(temp.val))
            {
                if(prev==null)
                {
                    temp=temp.next;
                    head=temp;
                }
                else
                {
                    temp=temp.next;
                    prev.next=temp;
                }
            }
            else
            {
                prev=temp;
                temp=temp.next;
            }
        }
        return head;
    }
}