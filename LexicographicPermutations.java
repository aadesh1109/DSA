public class LexicographicPermutations {
    public static void main(String[] args) {
        String str = "ABC";
        permutations(str);
    }

    private static void permutations(String str) {
        permutations(0,str,"");
    }

    private static void permutations(int i, String str, String s) {
        if (i==str.length())
        {
            System.out.println(s);
            return;
        }

        for (int j = 0; j < str.length() ; j++) {
            permutations(i+1,str,s+str.charAt(j));

        }
    }
}
