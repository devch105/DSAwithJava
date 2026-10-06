package LinkedList;

import java.util.HashMap;
import java.util.Map;

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
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = next = null;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    private void addFirst(Node node) {

        Node oldNode = head.next;
        node.next = oldNode;
        node.prev = head;

        oldNode.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        // this node was recently used;
        remove(node);
        addFirst(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);

            node.value = value;

            // It Becomes most Recently used;

            remove(node);
            addFirst(node);

            return;
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);

        addFirst(newNode);

        // if capacity reached Remove Least Recently Used

        if (map.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
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
