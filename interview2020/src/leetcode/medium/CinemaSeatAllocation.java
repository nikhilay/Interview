package leetcode.medium;

import java.util.HashMap;

public class CinemaSeatAllocation {
    //https://leetcode.com/problems/cinema-seat-allocation/discuss/546451/Java-Straightforward-solution-(bitwise)
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Integer> graph = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            int col = reservedSeat[1];
            graph.put(row, graph.getOrDefault(row, 0) | (1 << col));
        }
        //2345
        //1 -- > 100 --> 1100 -->11100 -->111100 -- 0+ 4 +8 +16 + 32 = 60
        int max = 2 * (n - graph.size());
        for (int row : graph.keySet()) {
            int reserved = graph.get(row);
            int count = 0;
            if ((reserved & (1 << 2)) == 0 &&
                    (reserved & (1 << 3)) == 0 &&
                    (reserved & (1 << 4)) == 0 &&
                    (reserved & (1 << 5)) == 0)
                count++;// check if seats 2,3,4,5 are available
            if ((reserved & (1 << 6)) == 0 &&
                    (reserved & (1 << 7)) == 0 &&
                    (reserved & (1 << 8)) == 0 &&
                    (reserved & (1 << 9)) == 0) count++;// check if seats 6,7,8,9 are available
            if ((reserved & (1 << 4)) == 0 &&
                    (reserved & (1 << 5)) == 0 &&
                    (reserved & (1 << 6)) == 0 &&
                    (reserved & (1 << 7)) == 0 && count == 0) count++;
            max += count;
        }
        return max;

    }
}
