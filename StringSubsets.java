import java.util.HashSet;
import java.util.Set;

public class StringSubsets {
    public static void main(String[] args) {
        String s = "abc";
        subset(s);
    }

    private static void subset(String s) {
        Set<String> set = new HashSet<>();
        subset(0,s,"",set);
        for (String S:
             set) {
            System.out.print(S + " ");
        }
    }
    private static void subset(int index , String S , String newStr,Set<String> set)
    {
        if (index==S.length())
        {
            set.add(newStr);
            return;
        }
        subset(index+1,S,newStr+S.charAt(index),set);
        subset(index+1,S,newStr,set);
    }
}
