public class BalancedBinaryTree_110 {
    public boolean isBalanced(TreeNode root) {
        return root == null || getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        int left = 0;
        int right = 0;
        if (root.left != null)
            left = getHeight(root.left);
        if (root.right != null)
            right = getHeight(root.right);
        if (left == -1 || right == -1)
            return -1;
        if (left >= right) {
            if (left - right > 1)
                return -1;
            else
                return left + 1;
        } else {
            if (right - left > 1)
                return -1;
            else
                return right + 1;
        }
    }
}
