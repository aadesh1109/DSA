import java.util.ArrayList;

public class CombinationProblem2 {
    public static void main(String[] args) {
        int sum = 7;
        generateCombinationsForSum(sum);
    }

    private static void generateCombinationsForSum(int sum) {
        generateCombinationsForSum(1, 0, sum, new ArrayList<>());
    }

    private static void generateCombinationsForSum(int start, int currSum, int sum, ArrayList<Integer> list) {

        if (currSum == sum) {
            System.out.println(list);
            return;
        }

        for (int i = start; i <= sum; i++) {
            if (currSum + i <= sum) {
                list.add(i);
                generateCombinationsForSum(i, currSum + i, sum, list);
                list.remove(list.size() - 1);
            } else
                return;
        }
    }
}
