package ctci;

public class isUnique {
    public static boolean isUniqueWord(String word){
        if(word.isEmpty()){
            return false;
        }
        int checker = 0;
        for(int i = 0; i<word.length();i++){
            int val = word.charAt(i)  - 'a';
            if ((checker & (1<<val))>0){
                return false;

            }
            checker |= (1 <<val);

        }
        return true;
    }
}
