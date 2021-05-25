package leetcode.easy;


import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) binaryTreePaths(root, "", paths);
        return paths;
    }

    private void binaryTreePaths(TreeNode root, String path, List<String> paths) {
        if (root.left == null && root.right == null) paths.add(path + root.val);
        if (root.left != null) binaryTreePaths(root.left, path + root.val + "->", paths);
        if (root.right != null) binaryTreePaths(root.right, path + root.val + "->", paths);
    }
}
