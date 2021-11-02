import java.util.HashMap;
import java.util.Map;

public class MinimumCoins {
    public static void main(String[] args) {
        int[] coins = {25, 10, 5};
        int amount = 30;
        System.out.println(minCoins(amount, coins));
    }

    private static int minCoins(int amount, int[] coins) {
        int minCoins = minCoins(amount, coins, new HashMap<>());
        if (minCoins == Integer.MAX_VALUE)
            return -1;
        else
            return minCoins;
    }

    private static int minCoins(int amount, int[] coins, Map<Integer, Integer> map) { //top-down dp

        if (amount == 0)
            return 0;

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (amount - coin >= 0) {
                int numOfCoins;
                if (!map.containsKey(amount - coin)) {
                    numOfCoins = minCoins(amount - coin, coins, map);
                    map.put(amount - coin, numOfCoins);
                } else
                    numOfCoins = map.get(amount - coin);

                minCoins = Math.min(minCoins, numOfCoins);
            }
        }
        if (minCoins == Integer.MAX_VALUE)
            return minCoins;
        return 1 + minCoins;
    }
}
