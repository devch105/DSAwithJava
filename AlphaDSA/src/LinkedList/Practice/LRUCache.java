package LinkedList.Practice;

import java.util.HashMap;

public class LRUCache {

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    class Node {
        
        int val;
        int key;
        Node next ;
        Node prev ;


        public  Node(int key , int val){
            this.key = key;
            this.val = val;
            next =  prev = null;
        }
    }

    private int Capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map ;

    public LRUCache(int capacity){

        this.Capacity = capacity;

        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1,-1);


        head.next = tail;
        tail.prev = head;
    }


    public void addFirst(Node node){
        Node  old = head.next;
        node.next = old;
        node.prev = head;
        old.prev = node;
        head.next = node;
    }

    public void remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void put(int key , int val){
        if(map.containsKey(key)){

           Node node = map.get(key);
           node.val = val;
            remove(node);
            addFirst(node);
        
            return;
        }

        Node newNode = new Node(key, val);
        map.put(key , newNode);
        addFirst(newNode);

        if(map.size()>=Capacity){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

    }


    public  int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        addFirst(node);

        return node.val;
    }

  
}

/*
 * A <-> B <-> C <-> D
 * 
 * (1) Add Node to Front
 * : addFirst(node)
 * (2) Remove Node
 * : remove(node)
 * (3) Move Node to Front
 * : remove(node);
 * : addFirst(node);
 * (4) Remove LRU
 * : remove(tail.prev)
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
