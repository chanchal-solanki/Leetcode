class LRUCache {
    HashMap<Integer,ListNode> map;
    ListNode head;
    ListNode tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = null;
        tail = null;
        this.capacity = capacity ;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        remove(map.get(key));
        insert(map.get(key));
        return map.get(key).val;
    }

    public void remove(ListNode node){
        if(node == head) head = head.next;
        if(node == tail) tail = tail.prev;
    
        ListNode prevH = node.prev;
        ListNode nextH = node.next;
            
        if(node.prev != null) node.prev.next = nextH;
        if(node.next != null) node.next.prev = prevH;

        if(head != null) head.prev = null;
        if(tail != null) tail.next = null;

        node.next = null;
        node.prev = null; 
    }

    public void insert(ListNode node ){
        if(head == null ){
            head = node;
            tail = node;
            return;
        }
        
        tail.next = node;
        node.prev = tail;
        tail = node;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
            map.remove(key);
        }
    
        ListNode node = new ListNode(key,value);
        map.put(key,node);
        insert(node);
        
        if(map.size()>capacity) {
            map.remove(head.key);
            remove(head); 
        }
    }
}
class ListNode{
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key,int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
        
    }
    public ListNode(){}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */