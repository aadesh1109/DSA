import java.util.ArrayList;

public class BreakString {
    public static void main(String[] args) {
        String str = "ABCD";
        breakString(str);
    }

    private static void breakString(String str) {
        breakString(str, 0, new ArrayList<>());

    }

    private static void breakString(String str, int index, ArrayList<String> list) {
        if (index == str.length()) {
            System.out.println(list);
            return;
        }
        for (int i = 1; i <= str.length(); i++) {
            if (index + i > str.length())
                return;
            list.add(str.substring(index, index + i));
            breakString(str, index + i, list);
            list.remove(list.size() - 1);

        }
    }
}
