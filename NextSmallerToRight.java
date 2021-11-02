import java.util.*;
//for stack concept read NextGreaterToRight!
public class NextSmallerToRight {
    public static void main(String[] args) {
        int[] arr = {1,3,0,0,1,2,4}; // o/p --> 0 0 -1 -1 -1 -1 -1
        int[] newArr = NSTR(arr);
        System.out.println(Arrays.toString(newArr));

    }

    private static int[] NSTR(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int i = arr.length-1;













        return result;
    }
}
