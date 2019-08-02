/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//O(n)
class KthSmallestElementInABST_230 {
    boolean find = false;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        return res;
    }

    public int kthSmallestHelper(TreeNode root, int k) {
        if (find)
            return -1;

        if (root == null)
            return 0;

        int numChildren = 1;
        numChildren += kthSmallestHelper(root.left, k);

        if (numChildren == k) {
            find = true;
            res = root.val;
            return -1;
        }
        else
            numChildren += kthSmallestHelper(root.right, k - numChildren);

        return numChildren;
    }
}