package leetcode.hard;


public class IntegerToEnglishWords {
    //https://leetcode.com/problems/integer-to-english-words/discuss/70627/Short-clean-Java-solution
    private final String[] BELOW_TEN = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] BELOW_TWENTY = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"};

    private final String[] BELOW_HUNDRED = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    private String helper(int num) {
        if (num == 0) return "";
        String res = new String();
        System.out.println(num);
        if (num < 10) res = BELOW_TEN[num];
        else if (num < 20) res = BELOW_TWENTY[num % 10];
        else if (num < 100) {
            res = BELOW_HUNDRED[num / 10] + " " + helper(num % 10);
        } else if (num < 1000) {
            res = BELOW_TEN[num / 100] + " Hundred " + helper(num % 100);
        } else if (num < 1000000) {
            res = helper(num / 1000) + " Thousand " + helper(num % 1000);
        } else if (num < 1000000000) {
            res = helper(num / 1000000) + " Million " + helper(num % 1000000);
        } else {
            res = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        }
        return res.trim();
    }
}
