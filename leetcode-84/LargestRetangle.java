import java.util.*;
/**
 * 利用stack，动态规划，如果当前bar的高度比栈顶元素的bar要高，push进栈；否则从stack里不断pop出元素作为left index，并计算area
 */
public class LargestRetangle {
    public static int largestRectangleArea(int[] heights) {
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

    public static void main(String args[]) {
        int hist[] = { 2, 1, 5, 6, 2, 3 };
        int max = largestRectangleArea(hist);
        System.out.println(max);
    }
}