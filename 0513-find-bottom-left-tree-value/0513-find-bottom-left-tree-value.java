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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        int level = findLevel(root);

        q.add(root);

        int countLevel = 1;
        int result = 0;
        while(!q.isEmpty())
        {
            int size = q.size();

            if(countLevel==level)
            {
                result = q.peek().val;
            }
            for(int i=0;i<size;i++)
            {
                TreeNode polled = q.poll();

                if(polled.left!=null)
                {
                    q.add(polled.left);
                }

                if(polled.right!=null)
                {
                    q.add(polled.right);
                }
            }
            countLevel++;
        }
        return result;
    }
    public static int findLevel(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        int left = findLevel(root.left);

        int right = findLevel(root.right);

        return Math.max(left,right) + 1;
    }
}