import java.util.HashMap;
import java.util.Map;

public class MinimumDistanceBetweenTwoNumbers {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 5, 4, 4, 2, 3};
        int x = 3;
        int y = 2;
        int minDis = findMinimumDistanceBetweenTwoNumbers(arr, x, y);
        System.out.println(minDis);
    }

    private static int findMinimumDistanceBetweenTwoNumbers(int[] arr, int x, int y) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        while (j < arr.length) {
            if (arr[j] == x || arr[j] == y) {
                map.putIfAbsent(arr[j], 0);
                int val = map.get(arr[j]);
                map.put(arr[j], val + 1);
                while (i < j && map.size() == 2) {
                    if (arr[i] == x || arr[i] == y) {
                        if (arr[i] != arr[j])
                            min = Math.min(min, j - i);
                        val = map.get(arr[i]);
                        map.put(arr[i], val - 1);
                        if (map.get(arr[i]) == 0)
                            map.remove(arr[i]);
                    }
                    i++;
                }
            }
            j++;
        }
        return min;
    }
}
