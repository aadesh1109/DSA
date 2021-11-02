// METHODS TO SOLVE THIS QUESTION
//1. Sorting O(n * log n)
//2. Min Heap - Priority queue O(n * log k)
//3. Partitioning... Average case - O(n) Worst case - O(n2)
public class FindTheKthLargestElementInTheArray {
    public static void main(String[] args) {
        int[] A = {7, 4, 6, 3, 9, 1};
        int k = 2;
        int kthLargest = findFindTheKthLargestElementInTheArray(A, k);
        System.out.println(kthLargest);
    }

    private static int findFindTheKthLargestElementInTheArray(int[] arr, int k) {
        if (k > arr.length)
            return -1;
        return findFindTheKthLargestElementInTheArray(0, arr.length - 1, arr, k);
    }

    private static int findFindTheKthLargestElementInTheArray(int l, int h, int[] arr, int k) {
        if (l == h)
            return arr[l];


        int partitionIndex = partition(l, h, arr);
        if (partitionIndex == arr.length - k)
            return arr[partitionIndex];
        else if (partitionIndex < arr.length - k)
            return findFindTheKthLargestElementInTheArray(partitionIndex + 1, h, arr, k);
        else
            return findFindTheKthLargestElementInTheArray(l, partitionIndex - 1, arr, k);


    }

    private static int partition(int l, int h, int[] arr) {
        int pivotIndex = (int) (Math.random() * (h - l + 1)) + l; //h+1 in place of h because h is exclusive, taking any random element as pivot
        swap(arr, pivotIndex, l); // now element at index l is pivot
        int pivot = arr[l];
        int i = l;
        int j = h;
        while (i < j) {
            while (i < h && arr[i] <= pivot)
                i++;
            while (j > l && arr[j] > pivot)
                j--;
            if (i < j)
                swap(arr, i, j);
        }
        swap(arr, l, j);
        return j;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
