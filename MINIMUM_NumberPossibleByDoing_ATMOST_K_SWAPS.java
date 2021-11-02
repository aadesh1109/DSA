import java.util.HashSet;

public class MINIMUM_NumberPossibleByDoing_ATMOST_K_SWAPS {
    public static void main(String[] args) {
        int number = 542131217;
        int k = 4;
        // convert digits of a given integer to a char array to facilitate swap operation on them
        char[] ch = String.valueOf(number).toCharArray();
        int minSoFar = number;
        long startTime = System.currentTimeMillis();
        int minimum = findMinimum(ch, k, minSoFar, new HashSet<>());
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println(minimum);
    }

    private static int findMinimum(char[] ch, int k, int minSoFar, HashSet<String> set) {
        minSoFar = Math.min(minSoFar, Integer.parseInt(String.valueOf(ch)));

        if (k == 0)
            return minSoFar;
//        System.out.println(String.valueOf(ch));
        for (int i = 0; i < ch.length - 1; i++) {
            for (int j = i + 1; j < ch.length; j++) {
                if (set.contains("" + i + j))
                    continue;
                if (ch[i] > ch[j]) {
                    swap(ch, i, j);
                    set.add("" + i + j);
//                    System.out.print("i=" + i + " " + "j=" + j + " ");System.out.println(String.valueOf(ch));
                    minSoFar = findMinimum(ch, k - 1, minSoFar, set);
                    swap(ch, i, j);
                    set.remove("" + i + j);
//                    System.out.print("i=" + i + " " + "j=" + j + " ");System.out.println(String.valueOf(ch));
                }
            }
        }
        return minSoFar;

    }

    private static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}