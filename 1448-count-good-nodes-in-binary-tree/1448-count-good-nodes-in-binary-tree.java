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
    public int goodNodes(TreeNode root) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int[] ans = new int[1];
        countGoodNodes(root,pq,ans);
        return ans[0];
    }
    public void countGoodNodes(TreeNode root,PriorityQueue<Integer> pq,int[] ans)
    {
        if(root==null)
        {
            return;
        }

        pq.add(root.val);

        if(pq.peek() <= root.val)
        {
            ans[0]++;
        }

        countGoodNodes(root.left,pq,ans);

        countGoodNodes(root.right,pq,ans);

        pq.remove(root.val);
    } 
}