package leetcode.easy;

public class FloodFill {
    //https://leetcode.com/problems/flood-fill/discuss/109584/Java-9-liner-DFS
    public int[][] floodFill(int[][] image, int row, int col, int newColor) {
        if (image[row][col] == newColor) return image;
        floodFill(image, row, col, image[row][col], newColor);
        return image;
    }

    private void floodFill(int[][] image, int row, int col, int color, int newColor) {
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != color) return;
        image[row][col] = newColor;
        floodFill(image, row + 1, col, color, newColor);
        floodFill(image, row - 1, col, color, newColor);
        floodFill(image, row, col + 1, color, newColor);
        floodFill(image, row, col - 1, color, newColor);

    }


}
