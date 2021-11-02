import java.util.Arrays;

public class GenerateAll_LEXICOGRAPHIC_PERMUTATIONS_OfAString {
    public static void main(String[] args) {
        String str = "AAB";
        findLexicographic(str);
    }

    private static void findLexicographic(String str) {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        findLexicographic(String.valueOf(ch), "");
    }

    private static void findLexicographic(String str, String permutation) {
        if (permutation.length() == str.length()) {
            System.out.println(permutation);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if(i!=0 && str.charAt(i)==str.charAt(i-1)) // to handle duplicates in case of alphabet repeats in string
                continue;
            findLexicographic(str, permutation + str.charAt(i));
        }
    }
}
