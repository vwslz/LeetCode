import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII_107 {
    List<List<Integer>> res = new LinkedList<List<Integer>>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        levelOrderBottomHelper(root, 0);
        return res;
    }

    public void levelOrderBottomHelper(TreeNode node, int level)
    {
        if (node == null)
            return;

        if (level >= res.size())
        {
            List<Integer> newList = new ArrayList<Integer>();
            newList.add(node.val);
            res.add(0, newList);
        }
        else
            res.get(res.size() - 1 - level).add(node.val);

        levelOrderBottomHelper(node.left, level + 1);
        levelOrderBottomHelper(node.right, level + 1);
    }
}
