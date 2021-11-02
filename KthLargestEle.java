import java.util.Random;

public class KthLargestEle //Using partitioning (can be done by min heap with nlog(k) complexity
{
    public static void main(String[] args) {
        int[] A = { 7, 4, 6, 3, 9, 1 };
        int k = 3;
        System.out.println(findKthLargest(A,k));
    }

    private static int findKthLargest(int[] a, int k) {
        return findKthLargest(0,a.length-1,a,a.length-k);
    }

    private static int findKthLargest(int start, int end, int[] a, int kLargestFinalPos) {
        int minInd = start;
        int maxInd = end;
        int pivotIndex = (int) (Math.random()*(maxInd-minInd+1)+minInd);
        swap(end,pivotIndex,a);
        int i = start;
        int j = start;
        int boundary =end;
        while (j<boundary)
        {
            if (a[j]<a[boundary])
            {
                swap(i,j,a);
                i++;
            }
            j++;
        }
        swap(i,end,a);
        if (i==kLargestFinalPos)
            return a[i];
        else if (kLargestFinalPos>i)
            return findKthLargest(i+1,end,a,kLargestFinalPos);
        else
            return findKthLargest(start,i-1,a,kLargestFinalPos);
    }

    private static void swap(int j, int pivotIndex, int[] a) {
        int temp = a[j];
        a[j]=a[pivotIndex];
        a[pivotIndex]=temp;
    }
}
