// O(log n)
public class SearchInRotatedSortedArrayII_81 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        return searchHelper(nums, left, right, target);
    }

    public boolean searchHelper(int[] n, int left, int right, int target) {
        if (left > right)
            return false;

        int middle = (left + right) / 2;
        if (n[left] == target || n[right] == target || n[middle] == target)
            return true;

        if (n[left] == n[middle - 1] && n[left] == n[middle + 1]) {
            return searchHelper(n, left, middle, target) || searchHelper(n, middle, right, target);
        }


        if (n[middle] > target) {
            if (n[left] > target && n[middle] > n[left])
                return searchHelper(n, middle + 1, right, target);
            else
                return searchHelper(n, left, middle - 1, target);
        }
        else {
            if (n[right] < target && n[middle] < n[right])
                return searchHelper(n, left, middle - 1, target);
            else
                return searchHelper(n, middle + 1, right, target);
        }
    }
}
