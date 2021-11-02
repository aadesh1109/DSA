public class EqualSumOddEvenIndex {
    public static void main(String[] args) {
        findNumbers(3);
    }

    private static void findNumbers(int numberLength) {
        findNumbers(0, 0, 0, numberLength, "");
    }

    private static void findNumbers(int i, int oddSum, int evenSum, int numberLength, String s) {

        if (i == numberLength) {
            if (oddSum == evenSum)
                System.out.println(s);
            return;
        }

        for (int j = 0; j <= 9; j++) {
            if (j == 0 && i == 0)
                continue;

            if (i % 2 == 0)
                findNumbers(i + 1, oddSum, evenSum + j, numberLength, s + j);
            else
                findNumbers(i + 1, oddSum + j, evenSum, numberLength, s + j);
        }

    }
}
