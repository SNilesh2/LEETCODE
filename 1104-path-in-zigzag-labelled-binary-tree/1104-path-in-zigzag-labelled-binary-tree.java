class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        TreeNode root = buildTree(label);

        List<Integer> result = new ArrayList<>();

        findPath(root,result,label);
        return result;
    }

    public static boolean findPath(TreeNode root,List<Integer> result,int label)
    {
        if(root==null)
        {
            return false;
        }

        if(root.val==label)
        {
            result.add(root.val);
            return true;
        }

        result.add(root.val);
        boolean left = findPath(root.left,result,label);
        if(left==true)
        {
            return true;
        }

        boolean right = findPath(root.right,result,label);
        if(right==true)
        {
            return true;
        }

        result.remove(result.size()-1);
        return false;
    }


    public static TreeNode buildTree(int label)
    {
        TreeNode root = new TreeNode(1);

        int value = 2;

        LinkedList<TreeNode> q = new LinkedList<>();

        q.add(root);

        boolean leftToRight = false;

        while(q.size()>0)
        {
            int size = q.size();

            for(int i=0;i<size;i++)
            {
                TreeNode polled = null;
                if(leftToRight)
                {
                    polled = q.removeFirst();

                    if(value>label)
                    {
                        return root;
                    }
                    polled.left = new TreeNode(value++);
                    q.addLast(polled.left);

                    if(value>label)
                    {
                        return root;
                    }
                    polled.right = new TreeNode(value++);
                    q.addLast(polled.right);

                }
                else
                {
                    polled = q.removeLast();

                    if(value>label)
                    {
                        return root;
                    }
                    polled.right = new TreeNode(value++);

                    q.addFirst(polled.right);

                    if(value>label)
                    {
                        return root;
                    }

                    polled.left = new TreeNode(value++);
                    q.addFirst(polled.left);
                }
            }
            leftToRight = !leftToRight;
        }
        return root;
    }
}