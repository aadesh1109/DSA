public class GenerateAllBALANCED_PARANTHESISOfGivenLength {
    public static void main(String[] args) {
        int n = 8;
        balParenthesis(n);
    }

    private static void balParenthesis(int n) {
        if (n % 2 != 0) {
            System.out.println("invalid input");
        } else {
            int openBracketLeft = n / 2;
            int closedBracketLeft = n / 2;
            generate("", n, openBracketLeft, closedBracketLeft);
        }


    }

    private static void generate(String str, int n, int openBracketLeft, int closedBracketLeft) {
        if (str.length() == n) {
            System.out.println(str);
            return;
        }
        if (openBracketLeft>0)
            generate(str + "(", n, openBracketLeft - 1, closedBracketLeft);
        if (openBracketLeft < closedBracketLeft && closedBracketLeft>0)
            generate(str + ")", n, openBracketLeft, closedBracketLeft - 1);
    }
}
