public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String longestPalindrome = longestPalindrome("babbad");
        System.out.println(longestPalindrome);
    }

    private static String longestPalindrome(String str) {
        String longestPalindrome = "";
        boolean[][] dp = new boolean[str.length()][str.length()];
        int diagonal = 0;
        while (diagonal < dp.length) {
            int r = 0, c = diagonal;
            while (c < dp.length) {
                boolean extremeEquality = str.charAt(r) == str.charAt(c);
                if (diagonal == 0)
                    dp[r][c] = true;
                else if (diagonal == 1) {
                    dp[r][c] = extremeEquality;
                } else
                    dp[r][c] = extremeEquality && dp[r + 1][c - 1];
                if (dp[r][c]) {
                    String palFound = str.substring(r, c + 1);
                    if (palFound.length() > longestPalindrome.length())
                        longestPalindrome = palFound;
                }
                r++;
                c++;
            }
            diagonal++;
        }
        return longestPalindrome;
    }
}
