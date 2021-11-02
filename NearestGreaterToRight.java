// STACK Question
// STACK is applied to lower time complexity, when inner loop is dependent on outer loop in brute force(higher time complexity) solution
import java.util.*;

public class NearestGreaterToRight {
    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 0, 0, 1, 2, 4, 6, 2, 1, 1, 3, 2, 4};
        int[] NearestGreaterToRightArray = findNearestGreaterToRight(arr);
        System.out.println(Arrays.toString(NearestGreaterToRightArray));
    }

    private static int[] findNearestGreaterToRight(int[] arr) {
        int[] NearestGreaterToRightArray = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            if (stack.isEmpty())
                NearestGreaterToRightArray[i] = -1;
            else
                NearestGreaterToRightArray[i] = stack.peek();
            stack.push(arr[i]);

        }
        return NearestGreaterToRightArray;
    }
}
