public class RecoverBinarySearchTree_99 {
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        while (root != null)
        {
            if (root.left != null)
            {
                TreeNode p = root.left;
                while (p.right != null && p.right != root)
                    p = p.right;
                if (p.right == null)
                {
                    p.right = root;
                    root = root.left;
                    continue;
                }
                else
                    p.right = null;
            }
            if (root.val < pre.val)
            {
                if (first == null)
                {
                    first = pre;
                }
                second = root;
            }
            pre = root;
            root = root.right;
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
