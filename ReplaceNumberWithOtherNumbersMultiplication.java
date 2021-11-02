import java.util.Arrays;

//Replace every array element with the product of every other element without using a division operator
public class ReplaceNumberWithOtherNumbersMultiplication {
    public static void main(String[] args) {
        int[] A = {5, 3, 4, 2, 6, 8};
        findProduct(A, 1, 0);
//        findProduct(A);
        System.out.println(Arrays.toString(A));
    }

    private static int findProduct(int[] a, int left, int ind) { //recursive solution
        if (ind == a.length) {
            return 1;
        }
        int right = findProduct(a, left * a[ind], ind + 1);
        int currEle = a[ind];
        a[ind] = left * right;
        return currEle * right;
    }

//    private static void findProduct(int[] A) {
//
//        int n = A.length;
//
//        // use two auxiliary arrays
//        int[] left = new int[n];
//        int[] right = new int[n];
//
//        // `left[i]` stores the product of all elements in subarray[0…i-1]
//        left[0] = 1;
//        for (int i = 1; i < n; i++) {
//            left[i] = A[i - 1] * left[i - 1];
//        }
//        System.out.println(Arrays.toString(left));
//
//        // `right[i]` stores the product of all elements in subarray[i+1…n-1]
//        right[n - 1] = 1;
//        for (int j = n - 2; j >= 0; j--) {
//            right[j] = A[j + 1] * right[j + 1];
//        }
//
//        System.out.println(Arrays.toString(right));
//        // replace each element with the product of its left and right subarray
//        for (int i = 0; i < n; i++) {
//            A[i] = left[i] * right[i];
//        }
//    }
}
