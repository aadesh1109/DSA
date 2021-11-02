import java.util.Arrays;
import java.util.Stack;

// STACK Question
// STACK is applied to lower time complexity, when inner loop is dependent on outer loop in brute force(higher time complexity) solution
public class StockSpanProblem {
    public static void main(String[] args) {
        int[] stockPrices = {5, 1, 2, 3, 0, 0, 1, 2, 4, 6, 2, 1, 1, 3, 2, 4};
        int[] result = findConsecutiveLessThanOrEqualsToPrices(stockPrices);
        System.out.println(Arrays.toString(result));

    }

    private static int[] findConsecutiveLessThanOrEqualsToPrices(int[] stockPrices) {
        int[] countArray = new int[stockPrices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < stockPrices.length; i++) {
            while (!stack.isEmpty() && stockPrices[stack.peek()] <= stockPrices[i])
                stack.pop();
            if (stack.isEmpty())
                countArray[i] = 1;
            else
                countArray[i] = i - stack.peek();
            stack.push(i);
        }
        return countArray;
    }
}
