public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricHelper(root.left, root.right);
    }
    public boolean isSymmetricHelper(TreeNode rootLeft, TreeNode rootRight)
    {
        if (rootLeft == null && rootRight == null)
            return true;
        return rootLeft != null && rootRight != null && rootLeft.val == rootRight.val
                && isSymmetricHelper(rootLeft.left, rootRight.right)
                && isSymmetricHelper(rootLeft.right, rootRight.left);
    }
}
