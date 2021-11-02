import java.util.HashMap;
import java.util.Map;

public class StaircaseProblem1 {
    public static void main(String[] args) {
        int n = 84;
        int waysToClimb = findWaysToClimb(n);
        System.out.println(waysToClimb);
    }

    private static int findWaysToClimb(int n) { //tabulation
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            if (i == 0 || i == 1)
                dp[i] = 1;
            else
                dp[i] = dp[i - 1] + dp[i - 2];

        }
        return dp[dp.length - 1];
    }

//    private static int findWaysToClimb(int n) {
//        Map<Integer,Integer> map = new HashMap<>();
//        return findWaysToClimb(n,map);
//    }
//
//    private static int findWaysToClimb(int n, Map<Integer,Integer> map) {
//        if (n==0)
//            return 1;
//        else if (n<0)
//            return 0;
//        if (!map.containsKey(n))
//            map.put(n,findWaysToClimb(n-1,map)+findWaysToClimb(n-2,map));
//        return map.get(n);
//    }


}
