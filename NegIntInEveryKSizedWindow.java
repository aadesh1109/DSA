import java.util.LinkedList;
import java.util.Queue;

public class NegIntInEveryKSizedWindow {
    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 2;
        findNegIntInEveryKSizedWindow(arr, k);
        printFirstNegativeInteger(arr, k, arr.length);
    }

    private static void findNegIntInEveryKSizedWindow(int[] arr, int k) { //O(k) space complexity solution...O(n) time complexity
        Queue<Integer> queueNegIndices = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0)
                queueNegIndices.add(i);
            if (i >= k - 1) {
                while (!queueNegIndices.isEmpty() && queueNegIndices.peek() < i - k + 1)
                    queueNegIndices.remove();
                if (!queueNegIndices.isEmpty())
                    System.out.print(arr[queueNegIndices.peek()] + " ");
                else
                    System.out.print(0 + " ");
            }
        }
        System.out.println();
    }

    public static void printFirstNegativeInteger(int[] arr, int k, int n) { //O(1) space complexity solution...O(n) time complexity
        int firstNegativeIndex = 0;
        int firstNegativeElement;

        for (int i = k - 1; i < n; i++) {
            // Skip out of window and positive elements
            while ((firstNegativeIndex < i) &&
                    (firstNegativeIndex <= i - k ||
                            arr[firstNegativeIndex] > 0)) {
                firstNegativeIndex++;
            }
            // Check if a negative element is
            // found, otherwise use 0
            if (arr[firstNegativeIndex] < 0) {
                firstNegativeElement = arr[firstNegativeIndex];
            } else {
                firstNegativeElement = 0;
            }
            System.out.print(firstNegativeElement + " ");
        }
    }
}
