package leetcode.easy;

public class AddBinary {
    // https://leetcode.com/problems/add-binary/discuss/24488/Short-AC-solution-in-Java-with-explanation
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int borrow = 0;

        while (i >= 0 || j >= 0) {
            int sum = borrow;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            borrow = sum / 2;
        }
        if (borrow != 0) sb.append(borrow);
        return sb.reverse().toString();

    }
}
