import java.util.HashMap;
import java.util.Map;

public class StringMatchesWithPatternOrNot {
    public static boolean isMatch(String str, int strInd, String pattern, int patInd, Map<Character, String> map) {
        if (str.length() < pattern.length()) {
            return false;
        }

        if (strInd == str.length() && patInd == pattern.length()) {
            return true;
        }

        if (strInd == str.length() || patInd == pattern.length()) {
            return false;
        }
        char key = pattern.charAt(patInd);
        if (map.containsKey(key)) {
            String s = map.get(key);
            int len = s.length();
            String valueToCompare;
            if (strInd + len < str.length()) {
                valueToCompare = str.substring(strInd, strInd + len);
            } else {
                valueToCompare = str.substring(strInd);
            }
            if (!s.equals(valueToCompare))
                return false;
            else
                return isMatch(str, strInd + len, pattern, patInd + 1, map);
        } else {
            for (int len = 1; len <= str.length() - strInd; len++) {
                map.put(key, str.substring(strInd, strInd + len));
                if (isMatch(str, strInd + len, pattern, patInd + 1, map)) {
                    return true;
                }
                map.remove(key);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "codesleepcode";
        String pat = "XYX";
        Map<Character, String> map = new HashMap<>();
        if (isMatch(str, 0, pat, 0, map)) {
            for (Map.Entry<Character, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } else {
            System.out.println("Solution doesn't exist");
        }
    }
}
