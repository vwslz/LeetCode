public class SumRootToLeafNumbers_129 {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return sumNumbersHelper(root, root.val);
    }

    public int sumNumbersHelper(TreeNode node, int num)
    {
        if (node.left == null && node.right == null)
            return num;

        int res = 0;
        if (node.left != null)
            res += sumNumbersHelper(node.left, num * 10 + node.left.val);
        if (node.right != null)
            res += sumNumbersHelper(node.right, num * 10 + node.right.val);
        return res;
    }
}
