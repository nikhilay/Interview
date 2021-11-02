package leetcode.medium;

public class MaximumAverageSubtree {
    double max = 0;

    public double maximumAverageSubtree(TreeNode root) {
        if( root == null) return max;
        helper(root);
        return max;

    }

    private Pair helper(TreeNode root){
        if(root == null) return new Pair(0,0);

        Pair left = helper(root.left);
        Pair right = helper(root.right);

        double sum = root.val + left.sum + right.sum;
        double count =  left.count + right.count + 1;
        max = Math.max(max, sum/count);
        return new Pair(sum, count);
    }

    class Pair{
        double sum;
        double count;

        Pair(double sum, double count){
            this.sum = sum;
            this.count = count;
        }
    }
}
