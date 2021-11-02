import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem //more time and space complexity than method 2
{
    public static void main(String[] args) {
        int[] arr = {60,40,20,30};
        int[] result = find(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] find(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result,1);
        int count = 0;
        int lastPopped = 0;
        int currPopped = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i<arr.length)
        {
            if (stack.isEmpty())
            {
                stack.push(arr[i]);
                result[i]+=(count+lastPopped);
                count=0;
                lastPopped=currPopped;
                i++;
            }

            else if (stack.peek()>arr[i])
            {
                stack.push(arr[i]);
                if (count != 0) {
                    result[i]+=(count+lastPopped);
                    count = 0;
                    lastPopped = currPopped;
                }
                i++;
            }
            else
            {
                stack.pop();
                count++;
                currPopped++;
            }
        }
        return result;
    }
}
