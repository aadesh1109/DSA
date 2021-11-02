import java.lang.reflect.Array;
import java.util.Arrays;

public class CombinationsOfElementsSatisfyingGivenConstraints {
    public static void main(String[] args) {
        int n = 3;
        generate(n);
    }

    private static void generate(int n) {
        int[] arr = new int[2 * n];
        generate(1, n, arr);
    }

    private static void generate(int num, int n, int[] arr) {

        if (num > n) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i + num + 1 < arr.length && arr[i] == 0 && arr[i + num + 1] == 0) {
                arr[i] = num;
                arr[i + num + 1] = num;
                generate(num + 1, n, arr);
                arr[i] = 0;
                arr[i + num + 1] = 0;
            }
        }
    }
}
