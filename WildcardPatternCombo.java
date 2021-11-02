import java.util.Arrays;
public class WildcardPatternCombo {
    public static void main(String[] args) {
        String s = "1?11?00?1?";
        printAllCombinations(s);
    }

    private static void printAllCombinations(String s)
    {
        printAllCombinations(0,s.toCharArray());
    }

    private static void printAllCombinations(int i, char[] ch) {

        if (i== ch.length)
        {
            System.out.println(Arrays.toString(ch));
            return;
        }

        if (ch[i]=='?')
        {
            for (char j = '0'; j <='1' ; j++) {
                ch[i]=j;
                printAllCombinations(i+1,ch);

            }
            ch[i]='?';
        }
        else
            printAllCombinations(i+1,ch);
    }
}