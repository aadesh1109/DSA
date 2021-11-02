import java.util.HashMap;
import java.util.Map;

public class _0_1_Knapsack {
    public static void main(String[] args) {
        int[] v = {20, 5, 10, 40, 15, 25};
        int[] w = {1, 2, 3, 8, 7, 4};
        int W = 10;

        System.out.println("Knapsack value is " +
                knapSack(0, v, w, W, new HashMap<>()));
    }

    private static int knapSack(int i, int[] v, int[] w, int W, Map<String, Integer> map) {
        if (i == v.length || W == 0)
            return 0;
        String key = i + "|" + W;

        if (!map.containsKey(key)) {
            int include = 0;
            if (W - w[i] >= 0)
                include = v[i] + knapSack(i + 1, v, w, W - w[i], map);

            int exclude = knapSack(i + 1, v, w, W, map);
            map.put(key, Math.max(include, exclude)); //memoization...top-down
        }
        return map.get(key);

    }
}
