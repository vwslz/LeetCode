import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        postorderTraversalHelper(root, list);
        return list;
    }

    public void postorderTraversalHelper(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        if(node.left != null)
            postorderTraversalHelper(node.left, list);
        if(node.right != null)
            postorderTraversalHelper(node.right, list);
        list.add(node.val);
    }
}
