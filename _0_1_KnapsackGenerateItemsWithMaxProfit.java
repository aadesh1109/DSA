import java.util.ArrayList;

public class _0_1_KnapsackGenerateItemsWithMaxProfit {
    public static void main(String[] args) {
        int[] profit = {20, 5, 10, 40, 15, 25};
        int[] weight = {1, 2, 3, 8, 7, 4};
        int totalWeight = 10;
        findMaxProfit(profit, weight, totalWeight);
    }

    private static void findMaxProfit(int[] profit, int[] weight, int totalWeight) {
        ArrayList<Integer> result = new ArrayList<>();
        int prof = findMaxProfit(0, profit, weight, totalWeight, 0, 0, result, new ArrayList<>());
        System.out.println(result);System.out.println(prof);
    }

    private static int findMaxProfit(int i, int[] profit, int[] weight, int totalWeight, int curProfit, int maxProf,
                                     ArrayList<Integer> result, ArrayList<Integer> list) {
        if (totalWeight < 0)
            return maxProf;

        if (i == profit.length) {
            if (curProfit > maxProf) {
                result.clear();
                result.addAll(list);
                return curProfit;
            }
            return maxProf;
        }

        list.add(i);
        maxProf = findMaxProfit(i + 1, profit, weight, totalWeight - weight[i], curProfit + profit[i], maxProf, result, list);
        list.remove(list.size() - 1);
        return findMaxProfit(i + 1, profit, weight, totalWeight, curProfit, maxProf, result, list);
    }
}
