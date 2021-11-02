import java.util.Stack;
//variation of NSL & NSR & stock span indexing technique
public class MaximumAreaInHistogram {
    public static void main(String[] args) {
        int[] arr = {6,2,5,4,5,1,6};
        int area = maxArea(arr);
        System.out.println(area);
    }

    private static int maxArea(int[] arr) {
        int max = Integer.MIN_VALUE;
        Stack<Pair> leftStack = new Stack<>();
        Stack<Pair> rightStack = new Stack<>();
        int[] leftResult = new int[arr.length];
        int[] rightResult = new int[arr.length];
        int i = 0;
        while (i<arr.length)
        {
            while (!leftStack.isEmpty() && leftStack.peek().stockVal>=arr[i])
            {
                    leftStack.pop();
            }

            if (leftStack.isEmpty())
            {
                leftResult[i]=i+1;
            }
            else{
                leftResult[i]=i-leftStack.peek().index;
            }
            leftStack.push(new Pair(arr[i],i));
            i++;
        }
        i=arr.length-1;
        while (i>=0)
        {
            while (!rightStack.isEmpty() && rightStack.peek().stockVal>=arr[i])
            {
                rightStack.pop();
            }

            if (rightStack.isEmpty())
            {
                rightResult[i]=arr.length-i;

            }
            else
            {
                rightResult[i]=rightStack.peek().index-i;
            }
            rightStack.push(new Pair(arr[i],i));
            i--;

        }
        i=0;
        while (i<arr.length)
        {
            max = Math.max(max,(leftResult[i]+rightResult[i]-1)*arr[i]);
            i++;
        }
        return max;
    }
}
