package leetcode.medium;


import java.util.TreeMap;

public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        if (changed == null || changed.length % 2 != 0) return new int[0];
        int[] result = new int[changed.length / 2];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : changed) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int i = 0;
        for ( int key : map.keySet()){
            if( map.get(key) > map.getOrDefault(key * 2, 0)) return new int[0];

            for(int j = 0 ;j <map.get(key);j++){
                result[i++] =  key;
                map.put(key * 2, map.get(key * 2) -1);

            }
        }
        return result;
    }
}
