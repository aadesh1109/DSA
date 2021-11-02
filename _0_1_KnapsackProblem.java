public class _0_1_KnapsackProblem {
    public static void main(String[] args) {
        int[] profit = {1, 2, 5, 6};
        int[] weight = {2, 3, 4, 5};
        int totalWeight = 8;
        int maxProfit = findMaxProfit(profit, weight, totalWeight);
        System.out.println(maxProfit);
    }

    private static int findMaxProfit(int[] profit, int[] weight, int totalWeight) {
        return findMaxProfit(0, profit, weight, totalWeight);
    }

    private static int findMaxProfit(int itemNum, int[] profit, int[] weight, int totalWeight) {

        if (totalWeight < 0)
            return Integer.MIN_VALUE; /*returning minimum value possible to prevent inclusion of previous item that made totalWeight negative,
             if we return 0 then still maybe inclusion makes bigger value than exclusion*/

        if (itemNum == profit.length || totalWeight == 0)
            return 0;

        int include = profit[itemNum] + findMaxProfit(itemNum + 1, profit, weight, totalWeight - weight[itemNum]);
        int exclude = findMaxProfit(itemNum + 1, profit, weight, totalWeight);
        return Math.max(include, exclude);
    }
}
