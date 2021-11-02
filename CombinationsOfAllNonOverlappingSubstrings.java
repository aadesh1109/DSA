public class CombinationsOfAllNonOverlappingSubstrings {
    public static void main(String[] args) {
        // input string
        String str = "ABCD";
        recur(str, "", 0);
    }

    private static void recur(String str, String s, int index) {
        if (index == str.length()) {
            System.out.println(s);
            return;
        }


        for (int breakAtLength = 1; breakAtLength <= str.length(); breakAtLength++) {
            if (index + breakAtLength <= str.length())
                recur(str, s + "(" + str.substring(index, index + breakAtLength) + ")" + " ", index + breakAtLength);
        }

    }
}
