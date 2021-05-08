package leetcode.easy;

public class ReformatPhoneNumber {
    //https://leetcode.com/problems/reformat-phone-number/discuss/978882/Java-1ms-with-StringBuilder
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c != ' ' && c != '-') {
                sb.append(c);
            }
        }
        //12345
        int j = 0;
        while (j < sb.length() - 4) {
            sb.insert(j + 3, '-');
            j = j + 4;
        }
        if (sb.length() - j == 4) {
            sb.insert(j + 2, '-');
        }
        return sb.toString();
    }
}
