public class BinaryTreeMaximumPathSum_124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return max;
    }

    public int maxPathSumHelper(TreeNode node)
    {
        if (node == null)
            return 0;

        int left = maxPathSumHelper(node.left);
        int right = maxPathSumHelper(node.right);
        if (left < 0)
            left = 0;
        if (right < 0)
            right = 0;
        int val = left + right + node.val;
        if (val > max)
            max = val;
        if (left > right)
            return left + node.val;
        else
            return right + node.val;
    }
}
