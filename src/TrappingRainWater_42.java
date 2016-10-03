// O(n)
public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int left_index = 0;
        int right_index = height.length - 1;

        if ((height.length <= 2))
            return 0;
        while (left_index < right_index) {
            if (height[left_index] > height[left_index + 1])
                break;
            else
                left_index++;
        }
        while (right_index > left_index) {
            if (height[right_index - 1] < height[right_index])
                break;
            else
                right_index--;
        }
        if (right_index == left_index)
            return 0;

        int sum = 0;

        while (left_index < right_index) {
            int h = 0;
            if (height[left_index] <= height[right_index]) {
                h = height[left_index];
                for (int i = left_index + 1; i <= right_index; i++) {
                    if (height[i] >= h) {
                        left_index = i;
                        break;
                    } else
                        sum += h - height[i];
                }
            } else {
                h = height[right_index];
                for (int i = right_index - 1; i >= left_index; i--) {
                    if (height[i] >= h) {
                        right_index = i;
                        break;
                    } else
                        sum += h - height[i];
                }
            }
        }
        return sum;
    }
}
