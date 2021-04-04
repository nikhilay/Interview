package leetcode.easy;

public class JewelsAndStones {
    //https://leetcode.com/problems/jewels-and-stones/discuss/607855/Java-Count-Clean-code-O(j%2Bs)
    public int numJewelsInStones(String jewels, String stones) {
        if (jewels.length() == 0 || stones.length() == 0) {
            return 0;
        }
        int total = 0;

        int[] stoneCount = new int[128];
        for (char s : stones.toCharArray()) {
            stoneCount[s]++;
        }
        for (char j : jewels.toCharArray()) {
            total += stoneCount[j];
        }
        return total;
    }
}
