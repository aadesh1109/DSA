import java.util.HashMap;
import java.util.Map;

//SLIDING WINDOW QUESTION(DYNAMIC WINDOW SIZE) with AUXILIARY DATA STRUCTURE
public class LongestSubstringWithKDistinctCharacters {
    public static void main(String[] args) {
        String str = "ABCCDBBBBBDEBCA";
        int k = 2;
        int maxLength = findLongestSubstringWithKDistinctCharacters(str, k);
        System.out.println(maxLength);
    }

    private static int findLongestSubstringWithKDistinctCharacters(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int i = 0;

        for (int j = 0; j < str.length(); j++) {
            if (!map.containsKey(str.charAt(j)))
                map.put(str.charAt(j), 1);
            else
                map.put(str.charAt(j), map.get(str.charAt(j)) + 1);

            if (map.size() == k)
                maxLen = Math.max(maxLen, j - i + 1);

            while (map.size() > k) {
                map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
                if (map.get(str.charAt(i)) == 0)
                    map.remove(str.charAt(i));
                i++;
            }
        }
        return maxLen;
    }
}
