public class FlattenBinaryTreeToLinkedList_114 {
    public void flatten(TreeNode root) {
        if (root != null )
            flattenHelper(root);
    }

    public TreeNode flattenHelper(TreeNode node) {
        TreeNode left = node.left;
        TreeNode right = node.right;

        if (left != null)
        {
            TreeNode leftTail = flattenHelper(node.left);
            node.right = left;
            leftTail.right = right;
            node.left = null;
            if (right != null)
                return flattenHelper(right);
            else
                return leftTail;
        }
        else if (right != null)
        {
            return flattenHelper(right);
        }
        else
            return node;
    }
}
