import java.util.*;

public class NumberOfWaysToMakeCoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 4;
        long ways = count(coins, sum, coins.length);
        System.out.println("total ways : " + ways);

    }

    private static long count(int[] S, int sum, int n) { //bottom-up dp
        Arrays.sort(S);
        long[][] dp = new long[n][sum+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(j==0)
                {
                    dp[i][j]=1;
                }
                else if(i==0)
                {
                    if(j%S[i]==0)
                        dp[i][j]=1;
                    else
                        dp[i][j]=0;
                }
                else{
                    if(S[i]>j)
                        dp[i][j]=dp[i-1][j];
                    else
                        dp[i][j]=dp[i-1][j]+dp[i][j-S[i]];
                }
            }
        }
        return dp[n-1][sum];
    }

//    private static long count(int i, int[] coins, int sum, Map<String, Long> map) { //top-down dp
//        if (sum == 0)
//            return 1;
//        if (sum < 0 || i == coins.length)
//            return 0;
//        String key = i + "|" + sum;
//        if (!map.containsKey(key)) {
//            long inc = count(i, coins, sum - coins[i], map);
//            long exc = count(i + 1, coins, sum, map);
//            map.put(key, inc + exc);
//        }
//        return map.get(key);
//    }

//    private static long count(int[] coins, int sum, int prevInd, Map<String, Long> map) { //topdown dp
//        if (sum == 0) {
//            return 1;
//        }
//        long counts = 0;
//        for (int i = prevInd; i < coins.length; i++) {
//            if (sum - coins[i] >= 0) {
//                String key = sum + "|" + (sum - coins[i]);
//                if (!map.containsKey(key))
//                    map.put(key, count(coins, sum - coins[i], i, map));
//                counts += map.get(key);
//            }
//        }
//        return counts;
//    }
}
