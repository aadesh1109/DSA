public class GenerateAllStringWithMore1Than0AtAnyPrefixOfString {
    public static void main(String[] args) {
        int n = 6;
        generate(n);
    }

    private static void generate(int n) {
        generate(n, "", 0, 0);
    }

    private static void generate(int n, String s, int oneCount, int zeroCount) {
        if (n == 0) {
            System.out.println(s);
            return;
        }

        generate(n - 1, s + 1, oneCount + 1, zeroCount);
        if (zeroCount<oneCount)
            generate(n - 1, s + 0, oneCount, zeroCount + 1);

    }
}
