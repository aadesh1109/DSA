import java.util.Arrays;
import java.util.HashMap;

public class _3_PartitionProblem {
    public static void main(String[] args) {
        int[] S = {7, 3, 2, 1, 5, 4, 8};

        if (partition(S)) {
            System.out.println("Can be partitioned");
        } else {
            System.out.println("Cannot be partitioned");
        }
    }

    private static boolean partition(int[] a) {
        if (a.length < 3)
            return false;
        int sum = Arrays.stream(a).sum();
        return (sum % 3 == 0) && partition(0, a, sum / 3, sum / 3, sum / 3, new HashMap<>());
    }

    private static boolean partition(int i, int[] a, int s1, int s2, int s3, HashMap<String, Boolean> map) {
        if (s1 < 0 || s2 < 0 || s3 < 0)
            return false;

        if (i == a.length) {
            return s1 == 0 && s2 == 0 && s3 == 0;
        }
        String key = i + "|" + s1 + "|" + s2 + "|" + s3;
        if (map.containsKey(key))
            return map.get(key);
        else {
            map.put(key, partition(i + 1, a, s1 - a[i], s2, s3, map) || partition(i + 1, a, s1, s2 - a[i], s3, map) || partition(i + 1, a, s1, s2, s3 - a[i], map));
        }
        return map.get(key);
    }
}

