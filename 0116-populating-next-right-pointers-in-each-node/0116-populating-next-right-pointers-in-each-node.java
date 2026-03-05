/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
        {
            return root;
        }

        Queue<Node> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                Node polled=q.poll();

                if(q.peek()!=null && i!=size-1)
                {
                    polled.next=q.peek();
                }

                if(polled.left!=null)
                {
                    q.add(polled.left);
                }
                if(polled.right!=null)
                {
                    q.add(polled.right);
                } 
            }
        }
        return root;
    }
}