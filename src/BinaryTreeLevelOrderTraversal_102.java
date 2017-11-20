import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrderHelper(root, 0);
        return list;
    }

    public void levelOrderHelper(TreeNode root, int index) {
        if (root == null)
            return;
        if (list.size() == index)
            list.add(new ArrayList<Integer>());
        list.get(index).add(root.val);
        levelOrderHelper(root.left, index + 1);
        levelOrderHelper(root.right, index + 1);
    }
}
