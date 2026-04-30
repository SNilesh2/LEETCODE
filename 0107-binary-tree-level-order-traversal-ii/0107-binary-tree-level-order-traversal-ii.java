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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        if(root==null)
        {
            return result;
        }

        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();

            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode polled = q.poll();
                temp.add(polled.val);

                if(polled.left!=null)
                {
                    q.add(polled.left);
                }

                if(polled.right!=null)
                {
                    q.add(polled.right);
                }
            }
            result.add(temp);
        }

        Collections.reverse(result);

        return result;
    }
}