import java.util.Stack;

// O(n ^ 2)
public class MaximalRectangle_85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int[][] heights = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0')
                    heights[i][j] = 0;
                else {
                    if (i == 0)
                        heights[i][j] = 1;
                    else
                        heights[i][j] = heights[i - 1][j] + 1;
                }
            }
            int area = largestRectangleArea(heights[i]);
            if (area > res)
                res = area;
        }
        return res;
    }


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
