import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
    List<String> res = new ArrayList<String>();

    public List<String> binaryTreePaths(TreeNode root) {
        String path = "";
        if (root == null)
            return new ArrayList<String>() {};

        path = path + root.val;
        binaryTreePathsHelper(path, root);
        return res;
    }

    public void binaryTreePathsHelper(String path, TreeNode root) {
        if (root.left == null && root.right == null)
            res.add(path);

        if (root.left != null) {
            String pathLeft = path + "->" + root.left.val;
            binaryTreePathsHelper(pathLeft, root.left);
        }
        if (root.right != null) {
            String pathRight = path + "->" + root.right.val;
            binaryTreePathsHelper(pathRight, root.right);
        }
    }
}
