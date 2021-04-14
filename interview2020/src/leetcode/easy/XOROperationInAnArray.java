package leetcode.easy;

public class XOROperationInAnArray {
    public int xorOperation(int n, int start) {
        int  i = 0;
        int result = 0 ;
        while (i < n){
            result = result ^ (start + 2 * i);
            i++;
        }
        return result;
    }
}
