package leetcode.easy;

public class ReverseInteger {

    public int reverse(int x) {

        long result = 0;
        //123
        while (x!=0){
            int remainder = x % 10;
            x = x/10;
            result = result * 10 + remainder;
            if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE){
                return 0;
            }
        }
    return (int) result;
    }
}
