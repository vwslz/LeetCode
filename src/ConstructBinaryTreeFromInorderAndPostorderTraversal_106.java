public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(postorder, inorder, postorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int[] inorder, int index, int start, int end) {
        if (index < 0 || start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index]);
        if (start == end)
            return root;
        int i;
        for (i = start; i <= end; i++) {
            if (postorder[index] == inorder[i]) {
                break;
            }
        }
        root.left = buildTree(postorder, inorder, index - (end - i) - 1, start, i - 1);
        root.right = buildTree(postorder, inorder, index - 1, i + 1, end);
        return root;
    }
}
