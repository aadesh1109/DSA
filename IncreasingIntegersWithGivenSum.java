import java.util.Arrays;

public class IncreasingIntegersWithGivenSum {
    public static void main(String[] args) {
        findCombos(5);
    }

    private static void findCombos(int sum)
    {
        findCombos(sum,"",sum);
    }

    private static void findCombos(int sum , String s , int numberRange) {
        if (sum==0)
        {
            System.out.println(Arrays.toString(s.toCharArray()));
            return;
        }

        for (int i=1; i<=numberRange ; i++) {
            if (sum-i>=0)
            {
                if (s.length()==0)
                {
                    findCombos(sum-i,s+i,numberRange);
                }
                else
                {
                    if (i>=Character.getNumericValue(s.charAt(s.length()-1)))
                        findCombos(sum-i,s+i,numberRange);

                }
            }
        }
        
    }
}
