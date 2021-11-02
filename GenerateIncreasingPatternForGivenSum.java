public class GenerateIncreasingPatternForGivenSum {
    public static void main(String[] args) {
        int sum = 7;
        findCombinations(sum);
    }

    private static void findCombinations(int sum) {
        findCombinations(1, "", sum, sum);
    }

    private static void findCombinations(int start, String str, int sum, int digitLimit) {
        if (sum == 0) {
            System.out.println(str);
            return;
        }

        for (int i = start; i <= digitLimit; i++) {
            if (sum-i<0)
                return;
            findCombinations(i, str + i + " ", sum - i, digitLimit);
        }

    }
}
