package leetcode.medium;

import java.util.TreeMap;

//https://leetcode.com/problems/snapshot-array/discuss/350562/JavaPython-Binary-Search
public class SnapshotArray {
    // TreeMap because to have log(n) order for get and set
    TreeMap<Integer, Integer>[] A;
    int snap_id = 0;
    public SnapshotArray(int length) {
        A = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            A[i] = new TreeMap<>();
            A[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        A[index].put(snap_id, val);
    }

    public int snap() {
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        //floorEntry because we are only measuring the difference . So, if we are looking for a value where it was s
        //snapped few snaps back, we have to do a binary search to get the right most value
        return A[index].floorEntry(snap_id).getValue();
    }
}
