// look for another optimized approach named as NDigitStrictlyIncreasingNumbersMethod2 in recursion folder
public class GenerateAllNDigits_STRICTLY_INCREASING_Numbers {
    public static void main(String[] args) {
        printStrictlyIncreasing(8, "");
    }

    private static void printStrictlyIncreasing(int n, String number) {
        if (n == 0) {
            System.out.println(number);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (number.equals(""))
                printStrictlyIncreasing(n - 1, number + i);
            else {
                if (Integer.parseInt("" + number.charAt(number.length() - 1)) < i)
                    printStrictlyIncreasing(n - 1, number + i);
            }
        }

    }
}
