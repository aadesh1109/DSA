// STACK Question
// STACK is applied to lower time complexity, when inner loop is dependent on outer loop in brute force(higher time complexity) solution
import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterToLeft {
    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 0, 0, 1, 2, 4, 6, 2, 1, 1, 3, 2, 4};
        int[] NearestGreaterToLeftArray = findNearestGreaterToLeft(arr);
        System.out.println(Arrays.toString(NearestGreaterToLeftArray));
    }

    private static int[] findNearestGreaterToLeft(int[] arr) {
        int[] NearestGreaterToLeftArray = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek()<=arr[i])
                stack.pop();
            if (stack.isEmpty())
                NearestGreaterToLeftArray[i]=-1;
            else
                NearestGreaterToLeftArray[i]=stack.peek();
            stack.push(arr[i]);
        }
        return NearestGreaterToLeftArray;
    }
}
