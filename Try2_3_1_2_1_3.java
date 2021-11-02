import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Try2_3_1_2_1_3 {
    public static void main(String[] args) {
        int n = 3;
        int[] occurrences = new int[n+1];
        Map<Integer , Integer> firstOccurrence = new HashMap<>();
        generate(0,n,occurrences,firstOccurrence,"");
    }

    private static void generate(int i, int n, int[] occurrences, Map<Integer, Integer> firstOccurrence,String s) {
        if (i==2*n)
        {
            System.out.println(Arrays.toString(s.toCharArray()));
            return;
        }

        for (int j = 1; j <=n ; j++) {
            if (!firstOccurrence.containsKey(j))
            {
                occurrences[j]++;
                firstOccurrence.put(j,i);
                generate(i+1,n,occurrences,firstOccurrence,s+j);
                firstOccurrence.remove(j);
                occurrences[j]--;
            }
            else
            {
                if (occurrences[j]<2 && s.length()-firstOccurrence.get(j)==j+1)
                {
                    occurrences[j]++;
                    generate(i+1,n,occurrences,firstOccurrence,s+j);
                    occurrences[j]--;
                }
            }

        }

    }
}
