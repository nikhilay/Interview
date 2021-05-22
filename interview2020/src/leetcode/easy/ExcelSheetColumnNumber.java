package leetcode.easy;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int count =0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int c = columnTitle.charAt(i) - 'A';
            result = result +  (int) Math.pow(26,count) * c;
            count++;
        }
    return result;
    }
}
