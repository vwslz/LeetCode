public class ConvertSortedListToBinarySearchTree_109 {
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null)
        {
            len++;
            node = node.next;
        }
        int[] nums = new int[len];
        node = head;
        len = 0;
        while (node != null)
        {
            nums[len++] = node.val;
            node = node.next;
        }

        return sortedListToBSTHelper(nums, 0, nums.length - 1);
    }

    public TreeNode sortedListToBSTHelper(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int index = left + (int)((right - left) / 2);
        TreeNode node = new TreeNode(nums[index]);
        node.left = sortedListToBSTHelper(nums, left, index - 1);
        node.right = sortedListToBSTHelper(nums, index + 1, right);

        return node;
    }
}
