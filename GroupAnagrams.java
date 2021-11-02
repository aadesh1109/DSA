import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(str);
        System.out.println(lists);


    }

    private static List<List<String>> groupAnagrams(String[] str) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : str) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
