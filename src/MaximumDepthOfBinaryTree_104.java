public class MaximumDepthOfBinaryTree_104 {
    int max = 0;
    public int maxDepth(TreeNode root) {
        maxDepthHelper(root, 0);
        return max;
    }

    public void maxDepthHelper(TreeNode node, int depth) {
        if (node == null)
        {
            if (depth > max)
                max = depth;
        }
        else
        {
            maxDepthHelper(node.left, depth + 1);
            maxDepthHelper(node.right, depth + 1);
        }
    }
}
