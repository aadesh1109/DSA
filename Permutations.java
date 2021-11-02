import java.util.Arrays;
import java.util.PriorityQueue;

public class Permutations {
    public static void main(String[] args) {
        String s = "ABC";
        permute(s);
    }

    private static void permute(String s) {
        permute(0, s.toCharArray());
    }

    private static void permute(int i, char[] ch) {
        if (i == ch.length) {
            System.out.println(Arrays.toString(ch));
            return;
        }
        for (int j = i; j < ch.length; j++) {
            swap(i, j, ch);
            permute(i + 1, ch);
            swap(i, j, ch);
        }
    }

    private static void swap(int i, int j, char[] ch) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
