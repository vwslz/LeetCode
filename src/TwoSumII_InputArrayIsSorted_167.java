// O(n)
public class TwoSumII_InputArrayIsSorted_167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right)
        {
            if (numbers[left] + numbers[right] == target)
                return new int[]{left + 1, right + 1};
            if (Math.abs(numbers[left + 1] + numbers[right] - target) > Math.abs(numbers[left] + numbers[right - 1] - target))
                right--;
            else
                left++;
        }
        return null;
    }
}
