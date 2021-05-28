package leetcode.easy;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null) return false;
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            int left = i - 1 >= 0 ? flowerbed[i - 1] : 0;
            int right = i + 1 < flowerbed.length ? flowerbed[i + 1] : 0;
            if (left == 0 && flowerbed[i] == 0 && right == 0) {
                System.out.println("true");
                flowerbed[i] = 1;
                n -= 1;
            }
        }

        return n == 0;
    }


}
