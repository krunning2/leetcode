public class LRUCache {
    
    private int capacity;
    private Map<Integer, Node> map;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node cur = map.get(key);
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            moveToTail(cur);
            return cur.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.size() >= capacity){
            head.next = head.next.next;
            head.next.next.pre = head;
        }
        if(map.containsKey(key)){
            map.get(key).val = value;
            get(key);
        }else{
            Node n = new Node(key, value);
            map.put(key, n);
            moveToTail(n);
        }
    }
    
    private void moveToTail(Node cur){
        cur.pre = tail.pre;
        tail.pre.next = cur;
        cur.next = tail;
        tail.pre = cur;
    }
    
    class Node{
        Node pre;
        Node next;
        int key;
        int val;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}