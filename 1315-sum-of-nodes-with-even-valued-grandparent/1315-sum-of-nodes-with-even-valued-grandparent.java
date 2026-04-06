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
    public int sumEvenGrandparent(TreeNode root) {
        int[] ans = new int[1];
        calculateSum(root,ans);
        return ans[0];
    }
    public static void calculateSum(TreeNode root,int[] ans)
    {
        if(root==null)
        {
            return;
        }

        if(root.left==null && root.right==null)
        {
            return;
        }

        if(root.val % 2 == 0)
        {
            sumNodes(root,ans);
        }

        calculateSum(root.left,ans);

        calculateSum(root.right,ans);

    }

    public static void sumNodes(TreeNode root,int[] ans)
    {
        TreeNode leftParent = root.left;
        if(leftParent!=null)
        {
            if(leftParent.left!=null)
            {
                ans[0] = ans[0] + leftParent.left.val;
            }
            if(leftParent.right!=null)
            {
                ans[0] = ans[0] + leftParent.right.val;
            }
        }

        TreeNode rightParent = root.right;
        if(rightParent!=null)
        {
            if(rightParent.left!=null)
            {
                ans[0] = ans[0] + rightParent.left.val;
            }
            if(rightParent.right!=null)
            {
                ans[0] = ans[0] + rightParent.right.val;
            }
        }
    }
}