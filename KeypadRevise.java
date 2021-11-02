import java.util.Arrays;
import java.util.List;

public class KeypadRevise {
    public static void main(String[] args) {
        List<List<Character>> keyPad = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(),
                Arrays.asList( 'A', 'B', 'C' ),
                Arrays.asList( 'D', 'E', 'F' ),
                Arrays.asList( 'G', 'H', 'I' ),
                Arrays.asList( 'J', 'K', 'L' ),
                Arrays.asList( 'M', 'N', 'O' ),
                Arrays.asList( 'P', 'Q', 'R', 'S'),
                Arrays.asList( 'T', 'U', 'V' ),
                Arrays.asList( 'W', 'X', 'Y', 'Z')
        );

        int[] input = { 2, 3, 4 };

        combinations(0,"",keyPad, input);


    }

    private static void combinations(int i, String s, List<List<Character>> keyPad, int[] input) {
        if (i==input.length)
        {
            System.out.println(s);
            return;
        }

        for (int j = 0; j < keyPad.get(input[i]).size() ; j++) {
            combinations(i+1,s+keyPad.get(input[i]).get(j),keyPad,input);

        }
    }
}
