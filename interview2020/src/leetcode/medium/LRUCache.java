package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    //https://leetcode.com/problems/lru-cache/discuss/45939/Laziest-implementation%3A-Java's-LinkedHashMap-takes-care-of-everything

    int capacity;
    int currCapacity = 0;
    Map<Integer, Node> memo;
    Node head;
    Node tail;

    class Node {
        int key;
        int val;
        Node pre;
        Node post;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        memo = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.post = tail;
        tail.pre = head;

    }

    public int get(int key) {
        Node n = memo.get(key);
        if (n == null) {
            return -1;
        }
        update(n);
        return n.val;
    }

    private void update(Node n) {
        remove(n);
        add(n);
    }

    private void remove(Node n) {
        Node before = n.pre;
        Node after = n.post;

        before.post = after;
        after.pre = before;
    }

    private void add(Node n) {
        Node post = head.post;
        head.post = n;
        n.pre = head;
        n.post = post;
        post.pre = n;


    }

    public void put(int key, int value) {
        Node n = memo.get(key);

        if (n == null) {
            n = new Node(key, value);
            add(n);
            currCapacity ++;
        } else{
            n.val = value;
            update(n);
        }
        memo.put(key, n);

        if(currCapacity> capacity){
            System.out.println("Nikhil capscity increased "+ currCapacity);
            Node del = tail.pre;
            remove(del);
            memo.remove(del.key);
            currCapacity--;
        }

    }
}
