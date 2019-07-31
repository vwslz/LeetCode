public class KthLargestElementInAnArray_215 {
    public int findKthLargest(int[] a, int k) {
        int p = quickSelect(a, 0, a.length - 1, k - 1);
        return a[p];
    }

    public int quickSelect(int[] list, int left, int right, int k) {
        if (left == right)
            return left;

        int pivotIndex = left, pivotValue = list[right];

        for (int i = left; i < right; i++)
        {
            if (list[i] > pivotValue)
                swap(list, pivotIndex++, i);
        }
        swap(list, pivotIndex, right);

        if (pivotIndex == k)
            return pivotIndex;
        else if (pivotIndex > k)
            return quickSelect(list, left, pivotIndex - 1, k);
        else
            return quickSelect(list, pivotIndex + 1, right, k);
    }

    public void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
