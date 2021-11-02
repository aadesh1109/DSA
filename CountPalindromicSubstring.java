public class CountPalindromicSubstring {
    public static void main(String[] args) {
        String str = "ABDCBCDBDCBBC";
        System.out.println(countSubstrings(str));
    }

    public static int countSubstrings(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            int oddLen = expand(str, i, i);
            int evenLen = expand(str, i, i + 1);
            count += (oddLen + evenLen);
        }
        return count;
    }

    public static int expand(String str, int low, int high) {
        int c = 0;
        while (low >= 0 && high < str.length() &&
                (str.charAt(low) == str.charAt(high))) {
            low--;
            high++;
            c++;
        }
        return c;
    }
}
