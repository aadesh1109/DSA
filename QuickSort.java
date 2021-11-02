import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {9, 0,3,-3, 5, 2, 6, 6, 8, -6, 1, 3,-6};
        quicksort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void quicksort(int[] a, int l, int h) {
        if (l < h) {
            int pivotIndex = partition(a, l, h);
            quicksort(a, l, pivotIndex - 1);
            quicksort(a, pivotIndex + 1, h);
        }
    }

    private static int partition(int[] a, int l, int h) {
        int pivot = a[l];
        int i = l;
        int j = h;
        while (i < j) {
            while (i < h && a[i] <= pivot) {
                i++;
            }
            while (j > l && a[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, l, j);
        return j;

    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
