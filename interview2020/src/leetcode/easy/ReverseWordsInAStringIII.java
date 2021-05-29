package leetcode.easy;

public class ReverseWordsInAStringIII {
    //https://leetcode.com/problems/reverse-words-in-a-string-iii/discuss/101906/C%2B%2B-Java-Clean-Code
    public String reverseWords(String s) {
        //s = "God Ding"
        char[] reverseString = s.toCharArray();
        for (int i = 0; i < reverseString.length; i++) {
            char c = reverseString[i];
            System.out.println(c);
            if (c != ' ') {
                int j = i ;
                while(j+1<reverseString.length && reverseString[j+1]!=' '){
                    j++;
                }
                reverseTheWord(reverseString, i,j);
                i = j;
            }
        }
    return String.valueOf(reverseString);
    }

    private void reverseTheWord(char[] word, int i, int j){
        while(i<j){
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
    }

}
