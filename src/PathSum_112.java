public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        sum -= root.val;
        if(sum == 0 && root.left == null && root.right == null) return true;
        if(root.left != null)
            if(hasPathSum(root.left,sum))
                return true;
        if(root.right != null)
            if(hasPathSum(root.right, sum))
                return true;
        return false;
    }
}
