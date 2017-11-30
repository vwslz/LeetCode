import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        rightSideViewHelper(root, res, 0);
        return res;
    }

    public void rightSideViewHelper(TreeNode root, List<Integer> list, int level) {
        if (root == null)
            return;
        if (level == list.size())
            list.add(root.val);
        rightSideViewHelper(root.right, list, level + 1);
        rightSideViewHelper(root.left, list, level + 1);
    }
}
