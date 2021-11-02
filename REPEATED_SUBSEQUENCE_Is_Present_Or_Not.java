import java.util.HashMap;
import java.util.Map;

public class REPEATED_SUBSEQUENCE_Is_Present_Or_Not {
    public static void main(String[] args) {
        String str = "XYBYAXBY";        // `XB` is repeated subsequence
        System.out.println(hasRepeatedSubsequence(str));
    }
    public static boolean hasRepeatedSubsequence(String str) {
        // map to store the frequency of each distinct character
        // of a given string
        Map<Character, Integer> freq = new HashMap<>();

        // update map with frequency
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // if the frequency of any character becomes 3,
            // we have found the repeated subsequence
            if (freq.get(c) >= 3) {
                return true;
            }
        }

        StringBuilder sb = new StringBuilder();

        // consider all repeated elements (frequency 2 or more)
        // and discard all non-repeating elements (frequency 1)
        for (char c : str.toCharArray()) {
            if (freq.get(c) == 2) {
                sb.append(c);
            }
        }

        // return false if `sb` is a palindrome
        return !isPalindrome(sb.toString(), 0, sb.length() - 1);
    }

    // Recursive function to check if `str[low…high]` is a palindrome or not
    public static boolean isPalindrome(String str, int low, int high) {
        // base case
        if (low >= high) {
            return true;
        }

        return (str.charAt(low) == str.charAt(high)) &&
                isPalindrome(str, low + 1, high - 1);
    }


}
