class Node
{
    int val;
    Node next;
    Node prev;
    public Node(int val)
    {
        this.val=val;
    }
}
class MyCircularDeque {
    final int size;
    int count;
    Node first=null;
    Node last=null;
    public MyCircularDeque(int k) {
        size=k;
        count=0;
    }
    
    public boolean insertFront(int value) {
        if(count==size)
        {
            return false;
        }
        Node nn=new Node(value);
        
        if(count==0)
        {
            first=nn;
            last=nn;
        }
        else
        {
            nn.next=first;
            first.prev=nn;
            first=nn;
        }
        count++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(count==size)
        {
            return false;
        }
        Node nn=new Node(value);

        if(count==0)
        {
            first=nn;
            last=nn;
        }
        else
        {
            last.next=nn;
            nn.prev=last;
            last=nn;
        }
        count++;
        return true;
    }
    
    public boolean deleteFront() {
        if(count==0)
        {
            return false;
        }

        if(count==1)
        {
            first=null;
            last=null;
        }
        else
        {
            first=first.next;
            first.prev=null;
        }
        count--;
        return true;
    }
    
    public boolean deleteLast() {
        if(count==0)
        {
            return false;
        }

        if(count==1)
        {
            first=null;
            last=null;
        }
        else
        {
            last=last.prev;
            last.next=null;
        }
        count--;
        return true;
    }
    
    public int getFront() {
        if(count==0)
        {
            return -1;
        }
        return first.val;
    }
    
    public int getRear() {
        if(count==0)
        {
            return -1;
        }
        return last.val;
    }
    
    public boolean isEmpty() {
        return (count==0);
    }
    
    public boolean isFull() {
        return (count==size);
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */