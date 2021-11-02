import java.util.HashSet;
import java.util.Set;

public class Interleaving {
    public static void main(String[] args) {
        String s1 = "AB";
        String s2 = "XY";
        interleaving(s1,s2);

    }

    private static void interleaving(String s1, String s2) {
        Set<String> set = new HashSet<>();
        interleaving(0,0,s1,s2,"",set);
    }

    private static void interleaving(int i1, int i2, String s1, String s2, String s,Set<String> set) {
        if (i1==s1.length() && i2==s2.length())
        {
            if (!set.contains(s))
            {
                System.out.println(s);
                set.add(s);
            }
            return;
        }

        if (i1<s1.length())
            interleaving(i1+1,i2,s1,s2,s+s1.charAt(i1),set);

        if (i2<s2.length())
            interleaving(i1,i2+1,s1,s2,s+s2.charAt(i2),set);
    }
}
