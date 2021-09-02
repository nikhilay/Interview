package leetcode.medium;

public class KokoEatingBananas {
    //https://leetcode.com/problems/koko-eating-bananas/discuss/152506/Binary-Search-Java-Python-with-Explanations
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getHighestPiles(piles);

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canEatAll(piles, mid, h)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return low;
    }

    private int getHighestPiles(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        return max;
    }

    private boolean canEatAll(int[] piles, int mid, int h) {
        int count = 0;
        for (int pile : piles) {
            count += pile / mid;
            if (pile % mid != 0) count++;
        }
        return count <= h;

    }
}
