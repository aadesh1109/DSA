public class PermutationsLexicographic {
    public static void main(String[] args) {
        String str = "AAB";
        permute(str);

    }

    private static void permute(String str) {
        permute(str,"");
    }

    private static void permute(String str , String s) {
        if (s.length()==str.length())
        {
            System.out.println(s);return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (i+1<str.length() && str.charAt(i)==str.charAt(i+1))
                continue;
            permute(str,s+str.charAt(i));
        }
    }
}
