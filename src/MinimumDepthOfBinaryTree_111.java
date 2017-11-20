public class MinimumDepthOfBinaryTree_111 {
    int depth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        helper(root,1);
        return depth;
    }

    public void helper(TreeNode root, int c){
        if(root.left == null && root.right == null)
            if(c < depth)
                depth = c;
        if(root.left != null)
            helper(root.left, c+1);
        if(root.right != null)
            helper(root.right,c+1);
    }
}
