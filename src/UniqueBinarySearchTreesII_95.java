import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(n)
public class UniqueBinarySearchTreesII_95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] res = new List[n+1];
        res[0] = new ArrayList<TreeNode>();
        if (n > 0) {
            res[1] = Arrays.asList(new TreeNode(1));
            for (int level = 2; level <= n; level++) {
                res[level] = new ArrayList<TreeNode>();
                for (int root = 1; root <= level; root++) {
                    for (TreeNode nodeL : res[root - 1]) {
                        for (TreeNode nodeR : res[level - root]) {
                            TreeNode node = new TreeNode(root);
                            node.left = cloneWithAdjust(nodeL, 0);
                            node.right = cloneWithAdjust(nodeR, root);
                            res[level].add(node);
                        }
                    }
                }
            }
        }
        return res[n];
    }

    public TreeNode cloneWithAdjust(TreeNode node, int diff){
        if(node == null)
            return null;
        TreeNode newNode = new TreeNode(node.val + diff);
        newNode.left = cloneWithAdjust(node.left, diff);
        newNode.right = cloneWithAdjust(node.right, diff);
        return newNode;
    }
}
