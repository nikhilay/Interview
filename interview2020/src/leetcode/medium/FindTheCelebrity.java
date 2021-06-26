package leetcode.medium;

public class FindTheCelebrity {
    //https://leetcode.com/problems/find-the-celebrity/discuss/71227/Java-Solution.-Two-Pass
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int person = 1; person < n; person++) {
            if (knows(celebrity, person)) {
                celebrity = person;
            }
        }

        for (int person = 0; person < n; person++) {

            if (celebrity != person && (knows(celebrity, person) || !knows(person,celebrity))) return -1;
        }
        return celebrity;
    }

    private boolean knows(int a, int b) {
        return true;
    }
}
