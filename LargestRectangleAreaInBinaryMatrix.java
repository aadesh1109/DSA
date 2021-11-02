import java.util.*;

// STACK Question
// STACK is applied to lower time complexity, when inner loop is dependent on outer loop in brute force(higher time complexity) solution
public class LargestRectangleAreaInBinaryMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 1, 1, 0}, {1, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 0, 0}, {1, 1, 1, 1, 0, 1}};
        int maxArea = findMaxArea(matrix);
        System.out.println(maxArea);
    }

    private static int findMaxArea(int[][] matrix) {
        int maxArea = Integer.MIN_VALUE;
        int[] leftSpan = new int[matrix.length];
        int[] rightSpan = new int[matrix.length];
        int[] topSpan = new int[matrix[0].length];
        int[] downSpan = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1)
                    count++;
                else
                    break;
            }
            leftSpan[i] = count;
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            int count = 0;
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == 1)
                    count++;
                else
                    break;
            }
            rightSpan[matrix.length - 1 - i] = count;
        }

        for (int col = 0; col < matrix[0].length; col++) {
            int count = 0;
            for (int row = matrix.length - 1; row >= 0; row--) {
                if (matrix[row][col] == 1)
                    count++;
                else
                    break;
            }
            downSpan[col] = count;
        }

        for (int col = matrix[0].length - 1; col >= 0; col--) {
            int count = 0;
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][col] == 1)
                    count++;
                else
                    break;
            }
            topSpan[matrix[0].length - 1 - col] = count;
        }

        maxArea = Math.max(maxArea, findMaxArea(leftSpan));
        maxArea = Math.max(maxArea, findMaxArea(rightSpan));
        maxArea = Math.max(maxArea, findMaxArea(topSpan));
        maxArea = Math.max(maxArea, findMaxArea(downSpan));

        return maxArea;
    }

    private static int findMaxArea(int[] heights) {
        int[] nextSmallestHeightToLeft = new int[heights.length];
        int[] nextSmallestHeightToRight = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            if (stack.isEmpty())
                nextSmallestHeightToRight[i] = Math.abs(i - heights.length);
            else
                nextSmallestHeightToRight[i] = Math.abs(i - stack.peek());
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            if (stack.isEmpty())
                nextSmallestHeightToLeft[i] = i + 1;
            else
                nextSmallestHeightToLeft[i] = Math.abs(i - stack.peek());
            stack.push(i);
        }
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nextSmallestHeightToRight[i] + nextSmallestHeightToLeft[i] - 1));
        }
        return maxArea;

    }
}
