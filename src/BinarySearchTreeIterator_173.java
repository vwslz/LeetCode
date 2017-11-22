import java.util.Stack;

// for next(), its amortized time complexity is O(1)
public class BinarySearchTreeIterator_173 {
    Stack<TreeNode> s = new Stack<TreeNode>();
    public BinarySearchTreeIterator_173 (TreeNode root) {
        pushLefts(root);
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }

    public int next() {
        TreeNode node = s.pop();
        if (node.right != null)
            pushLefts(node.right);
        return node.val;
    }

    public void pushLefts(TreeNode node)
    {
        while (node != null)
        {
            s.push(node);
            node = node.left;
        }
    }
}
