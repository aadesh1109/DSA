import java.util.Arrays;
import java.util.Stack;
//variation of NGL
public class StockSpanMethod2 //More efficient method with less space complexity
{
    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};
        int[] result = find(arr);
        System.out.println(Arrays.toString(result));
    }
    private static int[] find(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Pair> stack = new Stack<>();
        int i = 0;
        while (i<arr.length)
        {
            while (!stack.isEmpty() && stack.peek().stockVal<=arr[i])
                stack.pop();

            if (stack.isEmpty())
            {
                result[i]=i+1;
            }
            else if (stack.peek().stockVal>arr[i])
            {
                result[i]=i-stack.peek().index;
            }
            stack.push(new Pair(arr[i],i));
            i++;
        }
        return result;
    }
}
class Pair{
    int stockVal;
    int index;

    public Pair(int stockVal, int index) {
        this.stockVal = stockVal;
        this.index = index;
    }
}

