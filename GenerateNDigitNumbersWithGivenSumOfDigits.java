public class GenerateNDigitNumbersWithGivenSumOfDigits {
    public static void main(String[] args) {
        int sum = 42;
        int digits = 5;
        generate(sum, digits, "");
    }

    private static void generate(int sum, int digits, String str) {
        if (digits == 0 && sum == 0) {
            System.out.println(str);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (i == 0 && str.length() == 0)
                continue;
            if (digits-1>=0 && sum-i>=0)
                generate(sum - i, digits - 1, str + i);
        }


    }
}
