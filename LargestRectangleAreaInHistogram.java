import java.util.Arrays;
import java.util.Stack;

// STACK Question
// STACK is applied to lower time complexity, when inner loop is dependent on outer loop in brute force(higher time complexity) solution
public class LargestRectangleAreaInHistogram {
    public static void main(String[] args) {
        long[] histogramHeights = {6, 2, 5, 4, 5, 1, 6};
        long maxArea = findMaxArea(histogramHeights);
        System.out.println(maxArea);
    }

    private static Long findMaxArea(long[] histogramHeights) {
        long[] nextSmallestHeightToLeft = new long[histogramHeights.length];
        long[] nextSmallestHeightToRight = new long[histogramHeights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = histogramHeights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && histogramHeights[stack.peek()] >= histogramHeights[i])
                stack.pop();
            if (stack.isEmpty())
                nextSmallestHeightToRight[i] = Math.abs(i - histogramHeights.length);
            else
                nextSmallestHeightToRight[i] = Math.abs(i - stack.peek());
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i < histogramHeights.length; i++) {
            while (!stack.isEmpty() && histogramHeights[stack.peek()] >= histogramHeights[i])
                stack.pop();
            if (stack.isEmpty())
                nextSmallestHeightToLeft[i] = i + 1;
            else
                nextSmallestHeightToLeft[i] = Math.abs(i - stack.peek());
            stack.push(i);
        }
        long maxArea = Long.MIN_VALUE;
        for (int i = 0; i < histogramHeights.length; i++) {
            maxArea = Math.max(maxArea, histogramHeights[i] * (nextSmallestHeightToRight[i] + nextSmallestHeightToLeft[i] - 1));
        }
        return maxArea;
    }
}
