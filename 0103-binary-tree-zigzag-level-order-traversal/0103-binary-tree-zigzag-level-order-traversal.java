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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean lefttoright=true;
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> sub=new LinkedList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.poll();
                if(lefttoright) sub.addLast(temp.val);
                else sub.addFirst(temp.val);
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            lefttoright=!lefttoright;
            res.add(sub);
        }
        return res;
    }
}