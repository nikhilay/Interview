package leetcode.medium;


public class BullsAndCows {
    //https://leetcode.com/problems/bulls-and-cows/discuss/74621/One-pass-Java-solution
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] number = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int g = guess.charAt(i) - '0';
            int s = secret.charAt(i) - '0';
            if (g == s) {
                bulls++;
            } else {
                if(number[s] < 0) cows++;
                if(number[g] > 0) cows ++;
                number[s]++;
                number[g]--;

            }
        }
        return bulls + "A" + cows + "B";

    }
}
