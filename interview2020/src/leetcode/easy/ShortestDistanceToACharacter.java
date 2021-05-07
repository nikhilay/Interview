package leetcode.easy;

public class ShortestDistanceToACharacter {

    //https://leetcode.com/problems/shortest-distance-to-a-character/discuss/125788/C%2B%2BJavaPython-2-Pass-with-Explanation
    public int[] shortestToChar(String s, char c) {
        int l = s.length();
        int[] res = new int[l];
        int pos = -l;

        for (int i =0; i<s.length();i++){
            if(s.charAt(i)==c){
                pos = i;
            }
            res[i] = i - pos;
        }

        for(int i= pos -1; i>=0 ;i--){
            if(s.charAt(i)==c){
                pos = i;
            }
            res[i] = Math.min(res[i], pos - i);
        }

return res;
    }
}
