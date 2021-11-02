import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {
        String str = "ABCCDBBBBBDEBCA";
        int k = 2;
        int maxLength = findLongestSubstringWithKDistinctCharacters(str, k);
        System.out.println(maxLength);
    }

    private static int findLongestSubstringWithKDistinctCharacters(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int maxLen = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), 1);
            else
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            while (j < i && map.size() > k) {
                map.put(str.charAt(j), map.get(str.charAt(j)) - 1);
                if (map.get(str.charAt(j)) == 0)
                    map.remove(str.charAt(j));
                j++;
            }
            if (map.size() == k)
                maxLen = Math.max(maxLen, i - j + 1);

        }
        return maxLen;
    }
}
