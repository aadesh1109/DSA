import java.util.HashMap;

public class _0_1_KnapsackProblem {
    public static void main(String[] args) {
        int[] profit = {15, 14, 10, 45, 30};
        int[] weight = {2, 5, 1, 3, 4};
        int totalWeight = 7;
        int maxProfit = findMaxProfit(profit, weight, totalWeight);
        System.out.println(maxProfit);
    }

    private static int findMaxProfit(int[] profit, int[] weight, int totalWeight) { //BOTTOM UP solution(TABULAR)
        int[][] A = new int[weight.length+1][totalWeight+1];
        for (int i = 0; i < weight.length+1; i++) {
            for (int j = 0; j < totalWeight+1; j++) {
                if (i==0 || j==0)
                    A[i][j]=0;
                else if (weight[i-1]>j)
                    A[i][j]=A[i-1][j];
                else
                    A[i][j]=Math.max(A[i-1][j],profit[i-1]+A[i-1][j-weight[i-1]]);
            }
        }
        return A[A.length-1][A[0].length-1];
    }

//    private static int findMaxProfit(int[] profit, int[] weight, int totalWeight) { //TOP DOWN solution(MEMOIZATION)
//        return findMaxProfit(0, profit, weight, totalWeight, new HashMap<>());
//    }
//
//    private static int findMaxProfit(int i, int[] profit, int[] weight, int totalWeight, HashMap<String, Integer> stringIntegerHashMap) {
//        if (totalWeight < 0)
//            return Integer.MIN_VALUE;
//
//        if (i == profit.length || totalWeight == 0)
//            return 0;
//
//        String str = "" + i + totalWeight;
//
//        if (!stringIntegerHashMap.containsKey(str)) {
//            int include = profit[i] + findMaxProfit(i + 1, profit, weight, totalWeight - weight[i], stringIntegerHashMap);
//            int exclude = findMaxProfit(i + 1, profit, weight, totalWeight, stringIntegerHashMap);
//            stringIntegerHashMap.put(str, Math.max(include, exclude));
//        }
//
//        return stringIntegerHashMap.get(str);
//    }

}
