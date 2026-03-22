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
    public TreeNode bstToGst(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();

        inOrder(root,list);

        //suffix sum
        int size = list.size();
        int sum = list.get(size-1).val;
        for(int i=size-2;i>=0;i--)
        {
            sum = sum + list.get(i).val;
            list.get(i).val = sum;
        }
        return root;
    }
    public static void inOrder(TreeNode root,List<TreeNode> list)
    {
        if(root==null)
        {
            return;
        }

        inOrder(root.left,list);
        list.add(root);
        inOrder(root.right,list);
    }
}