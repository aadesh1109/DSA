import java.util.*;

public class ListsOfWordsToPhrases {
    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(
                Arrays.asList("John", "Emma"),
                Arrays.asList( "Plays", "Hates", "Watches" ),
                Arrays.asList( "Cricket", "Soccer", "Chess" )
        );

        printAllCombinations(list, "", 0);

    }

    private static void printAllCombinations(List<List<String>> list, String s, int i) {
        if (i==list.size())
        {
            System.out.println(s);
            return;
        }

        for (int j = 0; j < list.get(i).size() ; j++) {
            printAllCombinations(list,s+list.get(i).get(j)+" ",i+1);
        }
    }
}
