import java.lang.reflect.Array;
import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        String s = "123";
        permute(s);
    }

    private static void permute(String s) {
        permute(0,s.toCharArray());
    }

    private static void permute(int start ,char[] c) {
        if (start==c.length)
        {
            System.out.println(Arrays.toString(c));
            return;

        }

        for (int i = start; i < c.length; i++) {
            swap(start,i,c);
            permute(start+1,c);
            swap(start,i,c);
        }

    }

    private static void swap(int start, int i, char[] c) {
        char temp = c[start];
        c[start]=c[i];
        c[i]=temp;
    }
}
