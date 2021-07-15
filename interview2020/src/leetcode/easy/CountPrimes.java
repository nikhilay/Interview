package leetcode.easy;

public class CountPrimes {
    //https://leetcode.com/problems/count-primes/discuss/57588/My-simple-Java-solution
    //https://leetcode.com/problems/count-primes/discuss/473021/Time-Complexity-O(log(log(n))-Explained
    public int countPrimes(int n) {
        boolean[] isNotPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isNotPrime[i] == false) {
                count++;
                for (int j = 2; j * i < n; j++) {
                    isNotPrime[i * j] = true;
                }
            }
        }
    return count;
    }
}
