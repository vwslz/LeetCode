import java.util.ArrayList;
import java.util.List;

//
public class UniqueBinarySearchTreesII_95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] res = new List[n+1];
        res[0] = new ArrayList();
        if(n == 0) return res[0];
        res[0].add(null);
        res[1] = new ArrayList();
        res[1].add(new TreeNode(1));
        for(int i=2;i<=n;i++){
            res[i] = new ArrayList();
            for(int j=1;j<=i;j++){
                for(TreeNode nodeL: res[j-1]){
                    for(TreeNode nodeR: res[i-j]){
                        TreeNode node = new TreeNode(j);
                        node.left = nodeL;
                        node.right = clone(nodeR, j);
                        res[i].add(node);
                    }
                }
            }
        }
        return res[n];
    }

    static TreeNode clone(TreeNode node, int offset){
        if(node == null) return null;
        TreeNode newNode = new TreeNode(node.val + offset);
        newNode.left = clone(node.left, offset);
        newNode.right = clone(node.right, offset);
        return newNode;
    }
}