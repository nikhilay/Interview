package leetcode.easy;

public class MyHashMap {

    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    ListNode[] list;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        this.list = new ListNode[1000000];

    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = findIndex(key);
        if (list[index] == null) {
            list[index] = new ListNode(-1, -1);
        }
        ListNode node = findElement(list[index], key);
        if(node.next == null){
            node.next = new ListNode(key, value);
            return;
        } else {
            node.next.value = value;
        }

    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = findIndex(key);
        if (list[index] == null) return -1;
        ListNode node = findElement(list[index], key);
        if (node.next == null) return -1;
        return node.next.value;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = findIndex(key);
        if (list[index] == null) return;
        ListNode node = findElement(list[index], key);
        if (node.next == null) return;
        node.next = node.next.next;
    }

    private int findIndex(int key) {
        return key % list.length;
    }

    private ListNode findElement(ListNode curr, int key) {
        ListNode prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

}
