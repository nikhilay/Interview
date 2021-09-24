package leetcode.medium;

public class ConstructQuadTree {

    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }

    //https://leetcode.com/problems/construct-quad-tree/discuss/154565/Java-recursive-solution
    private Node helper(int[][] grid, int row, int col, int len) {
        if (len == 1) {
            return new Node(grid[row][col] == 1, true, null, null, null, null);
        }
        Node result = new Node();
        Node northWest = helper(grid, row, col, len / 2);
        Node northEast = helper(grid, row, col + len / 2, len / 2);
        Node southWest = helper(grid, row + len / 2, col, len / 2);
        Node southEast = helper(grid, row + len / 2, col + len / 2, len / 2);

        if (northWest.isLeaf && northEast.isLeaf && southWest.isLeaf && southEast.isLeaf
                && northWest.val == northEast.val && northWest.val == southWest.val && northWest.val == southEast.val) {
            result.isLeaf = true;
            result.val = northWest.val;

            // we do not assign northWest/northEast/southWest/southEast here to save storage. As the children will
            //have the same val and they are leaf
        } else {
            result.topLeft = northWest;
            result.topRight = northEast;
            result.bottomLeft = southWest;
            result.bottomRight = southEast;
        }

        return result;
    }


    private class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
