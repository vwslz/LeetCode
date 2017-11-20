import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        zigzagLevelOrderHelper(root, 0);
        return list;
    }

    public void zigzagLevelOrderHelper(TreeNode root, int index) {
        if (root == null)
            return;
        if (list.size() == index)
            list.add(new ArrayList<Integer>());
        if (index % 2 == 0)
            list.get(index).add(root.val);
        else
            list.get(index).add(0, root.val);
        zigzagLevelOrderHelper(root.left, index + 1);
        zigzagLevelOrderHelper(root.right, index + 1);
    }
}
