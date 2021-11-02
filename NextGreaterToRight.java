import java.util.*;
/* --> brute force is finding out the sol using two for
  loops in which inner loop is dependent on outer loop*/
/*  --> if inner loop is dependent on outer loop we can use STACK
for optimization to O(n) and it is identification to use stack   */
public class NextGreaterToRight {
    public static void main(String[] args) {
        int[] arr = {1,3,0,0,1,2,4};
        int[] newArr = NGTR(arr);
        System.out.println(Arrays.toString(newArr));
    }

    private static int[] NGTR(int[] arr) {
        int[] result = new int[arr.length];
        int i = arr.length-1;
        Stack<Integer> stack = new Stack<>();
/*        while (i>=0)
        {
            if (stack.isEmpty())
            {
                result[i]=-1;
                stack.push(arr[i]);
                i--;
            }
            else
            {
                if (stack.peek()>arr[i])
                {
                    result[i]=stack.peek();
                    stack.push(arr[i]);
                    i--;
                }
                else
                    stack.pop();
            }
        }*/

        //can be done by above method too but has comparatively more time complexity

        while (i>=0)
        {
            while (!stack.isEmpty() && stack.peek()<=arr[i])
                stack.pop();

            if (stack.isEmpty())
            {
                result[i]=-1;
            }
            else{
                result[i]=stack.peek();
            }
            stack.push(arr[i]);
            i--;
        }
        return result;
    }
}
