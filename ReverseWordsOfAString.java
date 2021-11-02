import java.util.ArrayList;

//how you doing ? => ? doing you how
public class ReverseWordsOfAString {
    public static void main(String[] args) {
        String str = "the sky is blue";
        String reversedWordsString = reverseWords(str);
        System.out.println(reversedWordsString);
    }

    private static String reverseWords(String str) {
        String s = "";
        int i = str.length()-1;
        while (i>=0)
        {
            while (i>=0 && str.charAt(i)==' ')
                i--;
            int j = i;
            while (i>=0 && str.charAt(i)!=' ')
                i--;
            if (s.isEmpty())
                s=s.concat(str.substring(i+1,j+1));
            else
                s=s.concat(" "+str.substring(i+1,j+1));
        }
        return s;
    }
}
