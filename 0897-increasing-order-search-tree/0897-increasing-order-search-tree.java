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
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root,list);

        int size = list.size();
        TreeNode newRoot = new TreeNode(list.get(0).val);
        TreeNode temp = newRoot;
        for(int i=1;i<size;i++)
        {
            TreeNode node = new TreeNode(list.get(i).val);
            temp.right = node;
            temp = node;
        }
        return newRoot;
    }
    public static void inorder(TreeNode root,List<TreeNode> list)
    {
        if(root==null)
        {
            return;
        }

        inorder(root.left,list);

        list.add(root);

        inorder(root.right,list);
    }
}