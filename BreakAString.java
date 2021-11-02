public class BreakAString {
    public static void main(String[] args) {
        String input = "ABCD";
        breakString(input, 0, "");
    }

    private static void breakString(String input, int i, String res) {
        if (i == input.length()) {
            System.out.println(res);
            return;
        }

        for (int len = 1; len <= input.length(); len++) {
            if (i + len <= input.length()) {
                String substr = "(" + input.substring(i, i + len) + ")";
                breakString(input, i + len, res + substr + " ");
            }

        }
    }
}