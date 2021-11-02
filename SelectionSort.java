import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 4, 1, 9, -2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length-1 ; i++) {
            int minInd = i;
            for (int j = i+1; j < arr.length ; j++) {
               if (arr[j]<arr[minInd])
                   minInd=j;
            }
            int temp = arr[i];
            arr[i]=arr[minInd];
            arr[minInd]=temp;

        }


    }
}
