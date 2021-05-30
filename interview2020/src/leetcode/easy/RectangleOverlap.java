package leetcode.easy;

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1 == null || rec2 == null) return false;
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3]) return false;

        if (rec1[2] <= rec2[0] //left
                || rec1[0] >= rec2[2] //right
                || rec1[1] >= rec2[3] //top
                || rec1[3] <= rec2[1] //bottom
        ) return false;
        return true;
    }
}
