import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (root == null) return res;

        ArrayList<Integer> list = new ArrayList<Integer>();
        search(res, list, root, sum, 0);

        return res;
    }

    public void search(List<List<Integer>> res, ArrayList<Integer> list, TreeNode root, int sum, int pathSum) {
        pathSum += root.val;
        list.add(root.val);
        if (root.left != null)  search(res, list, root.left, sum, pathSum);
        if (root.right != null) search(res, list, root.right, sum, pathSum);
        if (root.left == null && root.right == null && pathSum == sum) res.add((List<Integer>)(list.clone()));
        list.remove(list.size()-1);
    }
}
