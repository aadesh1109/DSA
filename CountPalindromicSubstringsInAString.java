public class CountPalindromicSubstringsInAString {
    public static void main(String[] args) {
        int count = countPalindrome("babbad");
        System.out.println(count);
    }

    private static int countPalindrome(String str) {
        boolean[][] dp = new boolean[str.length()][str.length()];
        int diagonal = 0, count = 0;
        while (diagonal < dp.length) {
            int r = 0, c = diagonal;
            while (c < dp.length) {
                if (diagonal == 0)
                    dp[r][c] = true;
                else if (diagonal == 1) {
                    dp[r][c] = str.charAt(r) == str.charAt(c);
                } else
                    dp[r][c] = str.charAt(r) == str.charAt(c) && dp[r + 1][c - 1];
                if (dp[r][c])
                    count++;
                r++;
                c++;
            }
            diagonal++;
        }
        return count;
    }
}
