import java.util.HashMap;
import java.util.Map;

class PatternMatching
{
    public static boolean match(String str, int i, String pat, int j, Map<Character, String> map){
        int n = str.length(), m = pat.length();
        if (n < m) {
            return false;
        }
        if (i == n && j == m) {
            return true;
        }
        if (i == n || j == m) {
            return false;
        }
        char curr = pat.charAt(j);

        if (map.containsKey(curr))
        {
            String s = map.get(curr);
            int k = s.length();
            String ss;
            if (i + k < str.length()) {
                ss = str.substring(i, i + k);
            } else {
                ss = str.substring(i);
            }

            if (ss.compareTo(s) != 0) {
                return false;
            }
            return match(str, i + k, pat, j + 1, map);
        }
        for (int k = 1; k <= n - i; k++)
        {
            map.put(curr, str.substring(i, i + k));
            if (match(str, i + k, pat, j + 1, map)) {
                return true;
            }
            map.remove(curr);
        }
        return false;
    }

    public static void main(String[] args)
    {
        // input string and pattern
        String str = "codesleepcode";
        String pat = "XYZ";

        // create a map to store mappings between the pattern and string
        Map<Character, String> map = new HashMap<>();

        // check for solution
        if (match(str, 0, pat, 0, map))
        {
            for (Map.Entry<Character, String> entry: map.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        else {
            System.out.println("Solution doesn't exist");
        }
    }
}