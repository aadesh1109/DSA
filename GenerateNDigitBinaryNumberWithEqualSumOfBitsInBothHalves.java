public class GenerateNDigitBinaryNumberWithEqualSumOfBitsInBothHalves {
    public static void main(String[] args) {
        int lengthNeeded = 4;
        generate(lengthNeeded);
    }

    private static void generate(int lengthNeeded) {
        generate(lengthNeeded, "", "", 0, 0);

    }

    private static void generate(int lengthNeeded, String leftString, String rightString, int leftSum, int rightSum) {
//        System.out.println("Function called ---> f(" + leftString + "," + rightString + "," + leftSum + "," + rightSum + ")");
        if (leftString.length() > lengthNeeded / 2 || rightString.length() > lengthNeeded / 2) {
//            System.out.println("                                returning...");
            return;
        }
        if (leftString.length() == lengthNeeded / 2 && rightString.length() == lengthNeeded / 2) {
            if (leftSum == rightSum) {
//                System.out.println("                                printing...");
                System.out.println(leftString + rightString);
            }
//            System.out.println("                                returning...");
            return;
        }

        for (int bit = 0; bit <= 1; bit++) {
            generate(lengthNeeded, leftString + bit, rightString, leftSum + bit, rightSum);
            generate(lengthNeeded, leftString, rightString + bit, leftSum, rightSum + bit);

        }
    }

}
