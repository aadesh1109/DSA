import java.util.Arrays;
import java.util.List;

public class KeypadCombinations {
    public static void main(String[] args) {
        List<List<Character>> keypad = Arrays.asList(
                // 0 and 1 digit doesn't have any characters associated
                Arrays.asList(),
                Arrays.asList(),
                Arrays.asList('A', 'B', 'C'),
                Arrays.asList('D', 'E', 'F'),
                Arrays.asList('G', 'H', 'I'),
                Arrays.asList('J', 'K', 'L'),
                Arrays.asList('M', 'N', 'O'),
                Arrays.asList('P', 'Q', 'R', 'S'),
                Arrays.asList('T', 'U', 'V'),
                Arrays.asList('W', 'X', 'Y', 'Z')
        );

        // input number in the form of an array (number cannot start from 0 or 1)
        int[] input = {2, 3, 4};
        findCombinations(keypad, input);
    }

    private static void findCombinations(List<List<Character>> keypad, int[] input) {
        findCombinations(keypad, input, "", 0);
    }

    private static void findCombinations(List<List<Character>> keypad, int[] input, String s, int i) {
        if (i == input.length) {
            System.out.println(s);
            return;
        }

        for (int j = 0; j < keypad.get(input[i]).size(); j++) {
            findCombinations(keypad, input, s + keypad.get(input[i]).get(j), i + 1);
        }
    }
}
