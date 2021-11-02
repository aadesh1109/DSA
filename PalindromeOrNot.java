public class PalindromeOrNot {
    public static void main(String[] args) {
        String str = "XYBYBYX";

        if (isPalindrome(str, 0, str.length() - 1)) {
            System.out.print("Palindrome");
        } else {
            System.out.print("Not Palindrome");
        }
    }

    private static boolean isPalindrome(String str, int low, int high) {

        if (low >= high)
            return true;

        return str.charAt(low) == str.charAt(high) && isPalindrome(str, low + 1, high - 1);
    }
}
