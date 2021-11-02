import java.util.Arrays;
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9,3,7,5,6,4,8,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        if (arr.length==1)
            return;

        int mid = (arr.length-1)/2;
        int[] a = Arrays.copyOfRange(arr,0,mid+1);
        int[] b = Arrays.copyOfRange(arr,mid+1,arr.length);

        sort(a);
        sort(b);
        merge(a,b,arr);
    }

    private static void merge(int[] a , int[] b , int[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i<a.length && j<b.length)
        {
            if (a[i]<b[j])
                arr[k++]=a[i++];
            else
                arr[k++]=b[j++];
        }

        while (i<a.length)
            arr[k++]=a[i++];

        while (j<b.length)
            arr[k++]=b[j++];
    }
}
