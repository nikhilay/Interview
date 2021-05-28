package leetcode.easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char start = s.charAt(i);
            char end = s.charAt(j);

            if(!isAlphaNumeric(start)){
                i++;
                continue;
            }
            if(!isAlphaNumeric(end)){
                j--;
                continue;
            }

            if(Character.toLowerCase(start)!=Character.toLowerCase(end)) return false;
            i++;
            j--;
        }
    return true;
    }

    private boolean isAlphaNumeric(char c){
        if(c>='0' && c<='9') return true;
        if(c>='a' && c<='z') return true;
        if(c>='A' && c<='Z') return true;
        return false;
    }
}
