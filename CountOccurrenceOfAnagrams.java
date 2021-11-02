import java.util.HashMap;
import java.util.Map;

public class CountOccurrenceOfAnagrams {
    public static void main(String[] args) {
        String text = "forxxorfxdofr";
        String pat = "for";
        int count = search(pat, text);
        System.out.println(count);
    }

    private static int search(String pat, String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, (int) i % 97 + 1);
        }
        int patSum = 0;
        for (int i = 0; i < pat.length(); i++) {
            patSum += map.get(pat.charAt(i));
        }
        int count = 0, currSum = 0;
        for (int i = 0; i < text.length(); i++) {
            currSum += map.get(text.charAt(i));
            if (i == pat.length() - 1) {
                if (currSum == patSum)
                    count++;
            }
            if (i > pat.length() - 1) {
                currSum -= map.get(text.charAt(i - pat.length()));
                if (currSum == patSum)
                    count++;
            }
        }
        return count;
    }
}
