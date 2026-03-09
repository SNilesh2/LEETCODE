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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
        {
            return null;
        }

        ListNode temp=head;
        ArrayList<Integer> sorted=new ArrayList<>();
        while(temp!=null)
        {
            sorted.add(temp.val);
            temp=temp.next;
        }

        return constructBST(sorted,0,sorted.size()-1);  
    }
    public static TreeNode constructBST(ArrayList<Integer> sorted,int start,int end)
    {
        if(start>end)
        {
            return null;
        }

        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(sorted.get(mid));

        root.left=constructBST(sorted,start,mid-1);
        root.right=constructBST(sorted,mid+1,end);

        return root;
    }
}