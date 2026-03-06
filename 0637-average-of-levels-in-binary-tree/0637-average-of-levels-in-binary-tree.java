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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int size=q.size();

            long sum=0;
            for(int i=0;i<size;i++)
            {
                TreeNode polled=q.poll();
                sum=sum + polled.val;

                if(polled.left!=null)
                {
                    q.add(polled.left);
                }
                if(polled.right!=null)
                {
                    q.add(polled.right);
                }
            }
            result.add((double)sum/(double)size);
        }
        return result;
    }
}