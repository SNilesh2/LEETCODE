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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int maxSum = Integer.MIN_VALUE;
        int level = 1;
        int result = 0;
        while(!q.isEmpty())
        {
            int size = q.size();

            int sum = 0;

            for(int i=0;i<size;i++)
            {
                TreeNode polled = q.poll();

                sum = sum + polled.val;

                if(polled.left!=null)
                {
                    q.add(polled.left);
                }

                if(polled.right!=null)
                {
                    q.add(polled.right);
                }
            }

            if(sum > maxSum)
            {
                maxSum = sum;
                result = level;
            }
            level++;
        }
        return result;
    }
}