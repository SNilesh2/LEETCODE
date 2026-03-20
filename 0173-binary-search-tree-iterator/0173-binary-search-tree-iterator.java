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
class BSTIterator {
    List<Integer> list = new ArrayList<>();
    int currInd=0;
    public BSTIterator(TreeNode root) {
        inOrder(root,list);
    }
    
    public static void inOrder(TreeNode root,List<Integer> list)
    {
        if(root==null)
        {
            return ;
        }

        inOrder(root.left,list);

        list.add(root.val);

        inOrder(root.right,list);
    }

    public int next() {
        return list.get(currInd++);
    }
    
    public boolean hasNext() {
        if(currInd<list.size())
        {
            return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */