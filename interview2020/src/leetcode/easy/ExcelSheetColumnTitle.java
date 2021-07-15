package leetcode.easy;

public class ExcelSheetColumnTitle {
    //https://leetcode.com/problems/excel-sheet-column-title/discuss/51399/Accepted-Java-solution/52065
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)('A' + n % 26));
            n /= 26;
        }
        sb.reverse();
        return sb.toString();

    }
}
