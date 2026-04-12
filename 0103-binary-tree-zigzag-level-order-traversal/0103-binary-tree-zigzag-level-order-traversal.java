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
        Queue<TreeNode> q = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        if(root==null)
        {
            return result;
        }

        q.add(root);

        boolean leftToRight = true;

        while(!q.isEmpty())
        {
            int size = q.size();

            List<Integer> list = new ArrayList<>();

            for(int i=0;i<size;i++)
            {
                TreeNode polled = q.poll();

                list.add(polled.val);

                if(polled.left!=null)
                {
                    q.add(polled.left);
                }

                if(polled.right!=null)
                {
                    q.add(polled.right);
                }
            }

            if(!leftToRight)
            {
                leftToRight=true;
                Collections.reverse(list);
            }
            else
            {
                leftToRight=false;
            }
            result.add(list);
        }
        return result;
    }
}