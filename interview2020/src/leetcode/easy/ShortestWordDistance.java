package leetcode.easy;

public class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int word1Index = -1;
        int word2Index = -1;
        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                word1Index = i;
            }
            if (wordsDict[i].equals(word2)) {
                word2Index = i;
            }
            if(word1Index!=-1 && word2Index!=-1)
                distance = Math.min(distance, Math.abs(word1Index - word2Index));
        }
        return distance;
    }
}
