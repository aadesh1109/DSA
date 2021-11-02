import java.util.Stack;

public class MaximumAreaRectangleInBinaryMatrix
{
    public static void main(String[] args) {
        int[][] A = {
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
        };
        System.out.println(maxArea(A));
    }

    private static int maxArea(int[][] arr) {
        int[] leftHistogram = new int[arr.length];
        int[] rightHistogram = new int[arr.length];
        int[] upHistogram = new int[arr.length];
        int[] downHistogram = new int[arr.length];

        int row = 0 ;
        while (row<arr.length)
        {
            int k = 0;int count = 0;
            while (k<arr.length && arr[row][k]==1)
            {
                k++;
                count++;
            }
            leftHistogram[row]=count;

            k = rightHistogram.length-1; count = 0;
            while (k>=0 && arr[row][k]==1)
            {
                k--;
                count++;
            }
            rightHistogram[row]=count;
            row++;
        }
        int col = 0;
        while (col<arr.length)
        {
            int k = 0;int count = 0;
            while (k<upHistogram.length && arr[k][col]==1)
            {
                k++;
                count++;
            }
            upHistogram[col]=count;

            k=downHistogram.length-1;count = 0;
            while (k>=0 && arr[k][col]==1)
            {
                k--;
                count++;
            }
            downHistogram[col]=count;

            col++;
        }
        return Math.max(Math.max(MAH(leftHistogram),MAH(rightHistogram)),Math.max(MAH(upHistogram),MAH(downHistogram)));

    }
    private static int MAH(int[] arr)
    {
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
