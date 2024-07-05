/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        insertcopy(head);
        randomlink(head);
        return nextlink(head);
    }
    public static void insertcopy(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            Node nextelement=temp.next;
            Node copyNode=new Node(temp.val);
            copyNode.next=nextelement;
            temp.next=copyNode;
            temp=nextelement;
        }
    }
    public static void randomlink(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            Node copy=temp.next;
            if(temp.random!=null)
            {
                copy.random=temp.random.next;
            }
            else
            {
                copy.random=null;
            }
            temp=temp.next.next;
        }
    }
    public static Node nextlink(Node head)
    {
        Node temp=head;
        Node dummy=new Node(-1);
        Node res=dummy;
        while(temp!=null)
        {
            res.next=temp.next;
            res=res.next;
            temp.next=temp.next.next;
            temp=temp.next;
        }
        return dummy.next;
    }
}