public class PopulatingNextRightPointersInEachNodeII_117 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode node = connectHelper(root);

        while (node != null)
            node = connectHelper(node);
    }

    public TreeLinkNode connectHelper(TreeLinkNode node) {
        if (node == null)
            return null;

        TreeLinkNode next = connectHelper(node.next);
        if (node.right != null)
        {
            node.right.next = next;
            next = node.right;
        }
        if (node.left != null)
        {
            node.left.next = next;
            next = node.left;
        }
        return next;
    }
}
