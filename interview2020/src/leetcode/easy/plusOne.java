package leetcode.easy;

public class plusOne {
    public int[] plusOne(int[] digits) {
        if(digits!=null){
            for(int i= digits.length -1; i>=0 ;i-- ){
                if((digits[i]) < 9){
                    digits[i]++;
                    return digits;

                }
                digits[i] =0;
            }
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] =1;
            return  newDigits;

        }
        return null;

    }
    //Accepted Solution: https://leetcode.com/problems/plus-one/discuss/24082/My-Simple-Java-Solution
}
