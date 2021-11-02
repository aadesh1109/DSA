import java.util.*;
//for stack concept read NextGreaterToRight!
public class NextGreaterToLeft {
    public static void main(String[] args) {
        int[] arr = {1,3,0,0,1,2,4}; // o/p --> -1 -1 3 3 3 3 -1
        int[] newArr = NGTL(arr);
        System.out.println(Arrays.toString(newArr));
    }
    private static int[] NGTL(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int i = 0 ;
        while (i<arr.length)
        {
            while (!stack.isEmpty() && stack.peek()<=arr[i])
                stack.pop();

            if (stack.isEmpty())
            {
                result[i]=-1;
            }
            else
            {
                result[i]=stack.peek();
            }
            stack.push(arr[i]);
            i++;
            }
        return result;
    }
}
