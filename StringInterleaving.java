import java.util.HashSet;
import java.util.Set;

public class StringInterleaving {
    public static void main(String[] args) {
        String X = "A";
        String Y = "A";

        // use set to handle duplicates
        findAllInterleaving(0, 0, "", X, Y, new HashSet<>());
    }

    private static void findAllInterleaving(int i, int j, String str, String x, String y, Set<String> set) {
        if (str.length() == x.length() + y.length()) {
            if (set.add(str))
                System.out.println(str);
            return;
        }


        if (i < x.length())
            findAllInterleaving(i + 1, j, str + x.charAt(i), x, y, set);

        if (j < y.length())
            findAllInterleaving(i, j + 1, str + y.charAt(j), x, y, set);

    }
}
