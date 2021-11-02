import java.util.*;

public class longestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        int longest = longestConsecutive(arr);
        System.out.println(longest);
    }

    private static int longestConsecutive(int[] arr) {
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : arr ) {
            set.add(i);
        }

        for (int i : set) {
            int curr = i;
            int count = 1;
            if (!set.contains(curr-1))
            {

                while (set.contains(curr+1))
                {
                    curr++;
                    count++;
                }
            }
            longest = Math.max(longest,count);

        }
        return longest;
    }
}
