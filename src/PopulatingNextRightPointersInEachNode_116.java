public class PopulatingNextRightPointersInEachNode_116 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode iter = root;
        while (iter != null)
        {
            TreeLinkNode cur = iter;
            while (cur != null){
                if (cur.left != null)
                    cur.left.next = cur.right;
                if (cur.right != null && cur.next != null)
                    cur.right.next=cur.next.left;
                cur=cur.next;
            }
            iter = iter.left;
        }
    }
}
