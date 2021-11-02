public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] A = {4,2,7,1,3};
        int sum = 10;

        if (subsetSum(A, sum)) {
            System.out.print("exists");
        } else {
            System.out.print("does not exist");
        }
    }

    private static boolean subsetSum(int[] a, int sum) { //BOTTOM-UP DP
        boolean[][] A = new boolean[a.length + 1][sum + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (j == 0)
                    A[i][j] = true;
                else if (i == 0)
                    A[i][j] = false;
                else if (a[i - 1] == j)
                    A[i][j] = true;
                else if (a[i - 1] > j)
                    A[i][j] = A[i - 1][j];
                else if (a[i - 1] <= j)
                    A[i][j] = A[i - 1][j] || A[i - 1][j - a[i - 1]];
            }
        }
        return A[A.length - 1][A[0].length - 1];
    }

//    private static boolean subsetSum(int[] a, int i, int sum, HashMap<String, Boolean> map) { //TOP-DOWN DP
//        if (sum == 0)
//            return true;
//
//        if (sum < 0 || i == a.length)
//            return false;
//
//        String key = i + "|" + sum;
//        if (map.containsKey(key))
//            return map.get(key);
//        else {
//            map.put(key, subsetSum(a, i + 1, sum - a[i], map) || subsetSum(a, i + 1, sum, map));
//        }
//        return map.get(key);
//    }

//    private static boolean subsetSum(int[] a, int i, int sum) {
//        if (sum == 0)
//            return true;
//
//        if (sum < 0 || i == a.length)
//            return false;
//
//        return subsetSum(a, i + 1, sum - a[i]) || subsetSum(a, i + 1, sum);
//    }
}
