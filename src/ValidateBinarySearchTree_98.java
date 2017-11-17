public class ValidateBinarySearchTree_98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTHelper(TreeNode node, double min, double max)
    {
        if (node == null)
            return true;
        if (node.val >= max || node.val <= min)
            return false;
        return isValidBSTHelper(node.left, min, node.val) && isValidBSTHelper(node.right, node.val, max);
    }
}
