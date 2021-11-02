// STRING PATTERN MATCH
public class KMP_Algorithm {
    public static void main(String[] args) {
        String str = "abcbcglx";
        String pattern = "acacabacacabacacac";
        int isMatchingAt = matchUsingKMPAlgo(str, pattern);
        System.out.println(isMatchingAt);
    }

    private static int matchUsingKMPAlgo(String str, String pattern) {

        // preparing array for longest prefix which is also a suffix upto that index
        int[] prefSuf = new int[pattern.length()]; // longest prefix which is also a suffix upto that index
        int i = 1, j = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                prefSuf[i] = j + 1;
                i++;
                j++;
            } else {
                if (j > 0)
                    j = prefSuf[j - 1];
                else {
                    prefSuf[i] = 0;
                    i++;
                }
            }
        }

        // matching of pattern start from here
        i = 0;
        j = 0;
        while (i < str.length() && j < pattern.length()) {
            if (str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0)
                    j = prefSuf[j - 1];
                else
                    i++;
            }
        }
        if (j == pattern.length())
            return i - pattern.length();
        else
            return -1;

    }
}
