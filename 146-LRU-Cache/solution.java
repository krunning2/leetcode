public class LRUCache {
    
    HashMap<Integer, DoubleLinkedList> map;
    DoubleLinkedList head;
    DoubleLinkedList tail;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new DoubleLinkedList(-1, -1);
        tail = new DoubleLinkedList(-1, -1);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DoubleLinkedList val = map.get(key);
            moveToTail(val);
            return val.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            DoubleLinkedList cur = map.get(key);
            cur.val = value;
            moveToTail(cur);
        }else{
            if(map.size() < capacity){
                DoubleLinkedList node = new DoubleLinkedList(key, value);
                map.put(key, node);
                moveToTail(node);
            }else{
                map.remove(head.next.key);
                head.next.next.pre = head;
                head.next = head.next.next;
                DoubleLinkedList node = new DoubleLinkedList(key, value);
                map.put(key, node);
                moveToTail(node);
            }
        }
    }
    
    private void moveToTail(DoubleLinkedList node){
        if(node.pre != null) node.pre.next = node.next;
        if(node.next != null) node.next.pre = node.pre;
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }
    
    class DoubleLinkedList{
        DoubleLinkedList next;
        DoubleLinkedList pre;
        int val;
        int key;
        DoubleLinkedList(int key, int val){
            this.val = val;
            this.key = key;
            next = null;
            pre = null;
        }
    }
}