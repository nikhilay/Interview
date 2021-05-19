package leetcode.easy;

public class MaximumNumberOfBalloons {
    public static final String BALLOON="balloon";
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        int min = Integer.MAX_VALUE;

        for(int i=0;i<text.length();i++){
            char c = text.charAt(i);
            count[c - 'a']++;
        }

        for(char c:BALLOON.toCharArray()){

            min = c=='l' || c=='o'?Math.min(count[c- 'a']/2,min):Math.min(count[c-'a'],min);
        }
     return min;
    }

}
