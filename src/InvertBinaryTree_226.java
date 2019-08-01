/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class InvertBinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode node = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = node;

        return root;
    }
}