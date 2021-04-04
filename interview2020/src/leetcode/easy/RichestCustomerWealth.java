package leetcode.easy;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        if (accounts == null) return 0;
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int totalIthCustomerVal = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                totalIthCustomerVal += accounts[i][j];
            }
            max = Math.max(max, totalIthCustomerVal);
        }
        return max;
    }
}
