/**
 * 这一题只要先理解了第84题，用stack求largest rectagle in histogram就好做了。
 * time complexity O(rows*cols)  space complexity O(rows*cols)
 */

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null)
            return 0;
        int rows = matrix.length;
        if (rows == 0)
            return 0;
        int cols = matrix[0].length;
        if (cols == 0)
            return 0;

        int[][] heights = new int[rows + 1][cols];
        //Arrays.fill(heights[0],0);

        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i - 1][j] == '0')
                    heights[i][j] = 0;
                else {
                    heights[i][j] = heights[i - 1][j] + 1;
                }
            }
        }
        int maxArea = 0;
        for (int i = 1; i <= rows; i++) {
            int max = largestRectangleArea(heights[i]);
            maxArea = Math.max(maxArea, max);
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();

        int i = 0;
        int maxArea = 0;
        int top;
        int area;

        while (i < heights.length) {
            if (st.isEmpty() || heights[st.peek()] <= heights[i]) {
                st.push(i++);
            } else {
                top = st.peek();
                st.pop();
                area = heights[top] * (st.isEmpty() ? i : (i - st.peek() - 1));
                maxArea = Math.max(maxArea, area);
            }
        }

        while (!st.isEmpty()) {
            top = st.peek();
            st.pop();
            area = heights[top] * (st.isEmpty() ? i : (i - st.peek() - 1));
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}