package ctci;

public class checkPermutation {

    public boolean checkPermutation(String word1, String word2){
        if(word1.length()!=word2.length()){
            return false;
        }
        int check =0;
        for(int i=0;i<word1.length();i++){
            check = check ^ word1.charAt(i) ^ word2.charAt(i);
        }
        return check==0;
    }
}
