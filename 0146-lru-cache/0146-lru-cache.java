class Node
{
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int key,int value)
    {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
class LRUCache {
    int cap;
    Node head = null;
    Node tail = null;
    HashMap<Integer,Node> map;
    public LRUCache(int capacity) {
        cap = capacity;
        
        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;

        map = new HashMap<>();
    }
    
    public int get(int key) {
        System.out.println("get" + key);
        //Not found
        if(!map.containsKey(key))
        {
            return -1;
        }

        //if found
        Node temp = map.get(key);

        //remove from the existing place
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        //add next after the head bcoz it is recently used
        temp.next = head.next;
        temp.prev = head;
        head.next.prev = temp;
        head.next = temp;

        return temp.value;
    }
    
    public void put(int key, int value) {
        System.out.println("put" + key);
        
        if(map.containsKey(key))
        {
            Node found = map.get(key);

            found.value = value;

            found.prev.next = found.next;
            found.next.prev = found.prev;

            found.next = head.next;
            found.prev = head;
            head.next.prev = found;
            head.next = found;
        }
        else
        {
            Node nn = new Node(key,value);

            nn.next = head.next;
            head.next.prev = nn;
            nn.prev = head;
            head.next = nn;

            map.put(key,nn);
        }
        

        if(map.size() > cap)
        {
            //Node to remove
            Node temp = tail.prev;

            map.remove(temp.key);

            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;

            temp.next = null;
            temp.prev = null;
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */