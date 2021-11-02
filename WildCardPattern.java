public class WildCardPattern {
    public static void main(String[] args) {
        char[] pattern = "1?11?00?1?".toCharArray();
        printAllCombinations(pattern, 0);
    }

    private static void printAllCombinations(char[] pattern, int i) {
        if (i==pattern.length)
        {
            System.out.println(pattern);
        }
        else
        {
            if (pattern[i]=='?')
            {
                for (char j = '0'; j <='1' ; j++) {
                    pattern[i]=j;
                    printAllCombinations(pattern,i+1);
                }
                pattern[i]='?';
                //can also put return here and remove below else in the code so that it doesnt go ahead with ?
            }
            else
                printAllCombinations(pattern,i+1);
        }
    }
}
