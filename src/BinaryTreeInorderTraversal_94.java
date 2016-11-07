import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)   return res;
        inorderHelper(root, res);
        return res;
    }

    public void inorderHelper(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        if (root.left != null)
            inorderHelper(root.left, list);
        list.add(root.val);
        if (root.right != null)
            inorderHelper(root.right, list);
    }
}
