public class ConvertSortedArrayToBinarySearchTree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int index = left + (int)((right - left) / 2);
        TreeNode node = new TreeNode(nums[index]);
        node.left = sortedArrayToBSTHelper(nums, left, index - 1);
        node.right = sortedArrayToBSTHelper(nums, index + 1, right);

        return node;
    }
}
