import java.util.Arrays;

public class SerializeAndDeserializeBinaryTree_297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";

        String res = serializeHelper(root, "");

        return "[" + res.substring(1) + "]";
    }

    public String serializeHelper(TreeNode root, String res) {
        if (root == null)
            return ",null";

        return "," + root.val + serializeHelper(root.left, res) + serializeHelper(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 2)
            return null;

        String[] nodes = data.substring(1, data.length()-1).split(",");
        return (TreeNode)deserializeHelper(nodes, 0)[0];
    }

    public Object[] deserializeHelper(String[] data, int currentIndex) {
        TreeNode root;
        Object[] res = new Object[2];
        if (currentIndex >= data.length || data[currentIndex].equals("null")) {
            root = null;
            res[0] = root;
            res[1] = currentIndex;
            return res;
        }


        root = new TreeNode(Integer.parseInt(data[currentIndex]));
        res = deserializeHelper(data, currentIndex + 1);
        root.left = res[0] == null ? null : (TreeNode)res[0];
        currentIndex = (int)res[1];
        res = deserializeHelper(data, currentIndex + 1);
        root.right = res[0] == null ? null : (TreeNode)res[0];
        currentIndex = (int)res[1];
        res[0] = root;
        res[1] = currentIndex;
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));