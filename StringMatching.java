import java.util.HashMap;
import java.util.Map;

public class StringMatching {
    public static void main(String[] args) {
        String input = "codesleepcode";
        String pattern = "xyx";

        Map<Character, String> map = new HashMap<>();

        boolean res = match(input, pattern, 0, 0, map);
        System.out.println(res);
        for (Map.Entry<Character, String> entry: map.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }

    private static boolean match(String input, String pattern, int i, int j, Map<Character, String> map) {
        if(i == input.length() && j == pattern.length())
            return true;

        if(i == input.length() || j == pattern.length())
            return false;

//        System.out.println("i="+i+" j="+j);
        char currChar = pattern.charAt(j);
//        System.out.println(currChar);
        /*for (Map.Entry<Character, String> entry: map.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }*/

        if(map.containsKey(currChar)){
            String existingSubstr = map.get(currChar);
            if(i+existingSubstr.length() <= input.length() && existingSubstr.equals(input.substring(i, i+existingSubstr.length()))){
                return match(input, pattern, i+existingSubstr.length(), j+1, map);
            }

            return false;
        }

        for(int len=1; i+len <= input.length(); len++){
            String substr = input.substring(i, i+len);
            boolean b;

            if(!map.containsKey(currChar)){
                map.put(currChar, substr);
                b = match(input, pattern, i+len, j+1, map);
//                System.out.println("b = "+b);
                if(b)
                    return true;

                map.remove(currChar);
            }
        }

        return false;
    }

}