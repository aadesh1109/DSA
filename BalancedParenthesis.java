public class BalancedParenthesis {
    public static void main(String[] args) {
        generate(8);

    }

    private static void generate(int i) {
        generate(0, 0, "", i);
    }

    private static void generate(int open, int close, String s, int total) {
        if (open + close == total) {
            System.out.println(s);
            return;
        }


        for (char ch = '('; ch <= ')'; ch++) {
            if (ch == '(') {
                if (open + 1 <= total / 2)
                    generate(open + 1, close, s + ch, total);
            } else {
                if (close < open)
                    generate(open, close + 1, s + ch, total);

            }
        }
    }
}
