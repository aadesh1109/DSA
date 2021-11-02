import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,1,3,6,8,5,7,4};

        /*sort(0,arr.length-1,arr);
        System.out.println(Arrays.toString(arr));*/
        System.out.println(partition(0,arr.length-1,arr));
        System.out.println(Arrays.toString(arr));


    }

    private static void sort(int l , int h , int[] arr) {
        if (l<h) {

            int pInd = partition(l, h, arr);
            sort(l, pInd - 1, arr);
            sort(pInd + 1, h, arr);
        }
    }

    private static int partition(int l , int h , int[] arr) {
        int pivot = arr[h];
        int j = l;
        for (int i = l; i < h ; i++) {
            if (arr[i]<pivot)
            {
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }

        }
        int temp = arr[j];
        arr[j]=pivot;
        arr[h]=temp;

        return j;

    }
}
