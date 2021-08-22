package leetcode.hard;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {
    //https://leetcode.com/problems/lfu-cache/discuss/94657/Java-solutions-of-three-different-ways.-PriorityQueue-%3A-O(capacity)-TreeMap-%3A-O(log(capacity))-DoubleLinkedList-%3A-O(1)
    // Solution one was my idea
    int capacity;
    long timeStamp;
    Map<Integer, Node> map;
    PriorityQueue<Node> pq;
    int curr;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        timeStamp = 0;
        map = new HashMap<>();
        pq = new PriorityQueue<>();
        curr = 0;
    }

    public int get(int key) {
        if (curr == 0) return -1;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            pq.remove(node);
            Node newNode = new Node(node.key, node.value, node.freq + 1, timeStamp);
            timeStamp++;
            pq.offer(newNode);
            map.put(key, newNode);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node newNode;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            pq.remove(node);
            curr --;
            newNode = new Node(key, value, node.freq + 1, timeStamp);
        } else {
            newNode = new Node(key, value, 1, timeStamp);
        }
        if (curr < capacity) {
            pq.offer(newNode);
            map.put(key, newNode);
            curr++;
        } else if (curr == capacity) {
            Node removed = pq.remove();
            map.remove(removed.key);
            pq.offer(newNode);
            map.put(key, newNode);
        }
        timeStamp++;

    }

    private class Node implements Comparable<Node> {
        int key;
        int value;
        int freq;
        long timeStamp;

        public Node(int key, int value, int freq, long timeStamp) {
            this.key = key;
            this.value = value;
            this.freq = freq;
            this.timeStamp = timeStamp;
        }

        @Override
        public int compareTo(Node o2) {
            if (this.freq == o2.freq) {
                return (int) (this.timeStamp - o2.timeStamp);
            }
            return this.freq - o2.freq;
        }
    }
}


