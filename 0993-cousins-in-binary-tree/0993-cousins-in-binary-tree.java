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

 class Pair
 {
    TreeNode node;
    TreeNode parent;
    public Pair(TreeNode node,TreeNode parent)
    {
        this.node = node;
        this.parent = parent;
    }
 }

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root,null));

        while(!q.isEmpty())
        {
            int size = q.size();

            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<size;i++)
            {
                Pair polled = q.poll();

                TreeNode currNode = polled.node;
                TreeNode parentNode = polled.parent;

                if(parentNode!=null)
                {
                    map.put(currNode.val,parentNode.val);
                }
                
                if(currNode.left!=null)
                {
                    q.add(new Pair(currNode.left,currNode));
                }

                if(currNode.right!=null)
                {
                    q.add(new Pair(currNode.right,currNode));
                }
            }

            if(map.containsKey(x) && map.containsKey(y) && (map.get(x)!=map.get(y)))
            {
                return true;
            }
        }

        return false;
    }
}