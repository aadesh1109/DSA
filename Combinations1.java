import java.util.*;
public class Combinations1 {
    public static void main(String[] args) {
        // N lists of characters
        List<List<Character>> list = Arrays.asList(
                Arrays.asList( 'A', 'B', 'C', 'D' ),
                Arrays.asList( 'E', 'F', 'G', 'H', 'I', 'J', 'K' ),
                Arrays.asList( 'L', 'M', 'N', 'O', 'P', 'Q' ),
                Arrays.asList( 'R', 'S', 'T' ),
                Arrays.asList( 'U', 'V', 'W', 'X', 'Y', 'Z' )
        );
        int[] keys = {0, 2, 0};
        find(list, keys, "", 0, new HashMap<>());
    }

    private static void find(List<List<Character>> list, int[] keys, String s, int i, Map<Integer, Character> map) {
        if (i==keys.length)
        {
            System.out.println(s);return;
        }
        if (!map.containsKey(keys[i])) {
            for (int j = 0; j < list.get(keys[i]).size(); j++) {
                map.put(keys[i], list.get(keys[i]).get(j));
                find(list, keys, s + list.get(keys[i]).get(j), i + 1, map);
                map.remove(keys[i]);
            }
        }
        else
            find(list, keys, s + map.get(keys[i]), i + 1, map);
    }

    private static void find(List<List<Character>> list, int[] keys, //can also be done like this
                             String s, int i, Map<Integer, //but takes more space complexity as set is also being used as extra space
            Character> map , Set<String> set) {
        if (i==keys.length)
        {
            if (!set.contains(s))
            {
                System.out.println(s);
                set.add(s);
            }

            return;
        }

        for (int j = 0; j < list.get(keys[i]).size() ; j++) {
            if (!map.containsKey(keys[i]))
            {
                map.put(keys[i],list.get(keys[i]).get(j));
                find(list,keys,s+list.get(keys[i]).get(j),i+1,map,set);
                map.remove(keys[i]);
            }
            else
                find(list,keys,s+map.get(keys[i]),i+1,map,set);
        }
    }
}
