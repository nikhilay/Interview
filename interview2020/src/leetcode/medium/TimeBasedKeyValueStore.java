package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TimeBasedKeyValueStore {
    Map<String, ArrayList<Node>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Node(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            ArrayList<Node> list = map.get(key);
            int low = 0;
            int high = list.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (list.get(mid).timestamp == timestamp) {
                    return list.get(mid).value;
                } else if (list.get(mid).timestamp > timestamp) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            low--;
            if (low < 0) return "";
            return list.get(low).value;
        }

        return "";
    }

    class Node {
        String value;
        int timestamp;

        public Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}

