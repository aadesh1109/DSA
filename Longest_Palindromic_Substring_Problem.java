public class Longest_Palindromic_Substring_Problem {
    public static String expand(String str, int low, int high) {
        while (low >= 0 && high < str.length() &&
                (str.charAt(low) == str.charAt(high))) {
            low--;
            high++;
        }
        return str.substring(low + 1, high);
    }

    public static String findLongestPalindromicSubstring(String str) {
        String maxStr = "";
        for (int i = 0; i < str.length(); i++) {
            String currStr1 = expand(str, i, i);
            String currStr2 = expand(str, i, i + 1);
            String maxOfBothCases = (currStr1.length() > currStr2.length()) ? currStr1 : currStr2;
            maxStr = (maxOfBothCases.length() > maxStr.length()) ? maxOfBothCases : maxStr;
        }
        return maxStr;
    }

    public static void main(String[] args) {
        String str = "ABDCBCDBDCBBC";
        System.out.println("The longest palindromic substring of " + str + " is "
                + findLongestPalindromicSubstring(str));
    }
}
