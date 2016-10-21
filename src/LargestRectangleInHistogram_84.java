import java.util.Stack;

// O(n)
public class LargestRectangleInHistogram_84 {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<int[]>();
        int h = -1, res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > h) {
                h = heights[i];
                int[] ele = new int[]{h, i};
                stack.push(ele);
            }
            else if (heights[i] < h){
                h = heights[i];
                int index = i;
                while (stack.size() > 0 && stack.peek()[0] > h) {
                    int[] ele = stack.pop();
                    index = ele[1];
                    int area = ele[0] * (i - ele[1]);
                    if (area > res)
                        res = area;
                }
                stack.push(new int[]{h, index});
            }
        }
        while (stack.size() > 0) {
            int[] ele = stack.pop();
            int area = ele[0] * (heights.length - ele[1]);
            if (area > res)
                res = area;
        }
        return res;
    }
}
