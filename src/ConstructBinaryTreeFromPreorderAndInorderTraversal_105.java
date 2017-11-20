public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int index, int start, int end) {
        if (index >= preorder.length || start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[index] == inorder[i]) {
                break;
            }
        }
        root.left = buildTree(preorder, inorder, index + 1, start, i - 1);
        root.right = buildTree(preorder, inorder, index + i - start + 1, i + 1, end);
        return root;
    }
}
