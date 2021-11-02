import java.util.*;

public class ZeroSum {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 2, 7, 1, 9 };
        int sum = 15;
        List<Integer> list = longestSubArrayWithSum(arr,sum);
        System.out.println(list.toString());
    }

    private static List<Integer> longestSubArrayWithSum(int[] arr, int sum) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        int currSum = 0;

        for (int i = 0; i < arr.length ; i++) {
            currSum+=arr[i];
            map.putIfAbsent(currSum,new ArrayList<>());
            if (map.containsKey(currSum-sum))
            {
                for (int k : map.get(currSum-sum) ) {
                    if (i-k < list.size())
                    {
                        list.clear();
                        for (int j = k+1; j <= i ; j++) {
                            list.add(arr[j]);
                        }
                    }
                }
            }
            map.get(currSum).add(i);

        }

        return list;
    }

}
