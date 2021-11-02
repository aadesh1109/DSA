import java.util.*;

public class InterLeavings {
    public static void main(String[] args) {
        String s1 = "AB";
        String s2 = "XY";
        findInterLeavings(s1,s2);
    }

    private static void findInterLeavings(String s1, String s2) {
        findInterLeavings(0,0,s1,s2,"",new HashSet<>());
    }

    private static void findInterLeavings(int i , int j , String s1, String s2,String s,Set<String> set) {
        if(s.length()==s1.length()+s2.length()) //or if(i1==s1.length() && i2==s2.length())
        {
            if (!set.contains(s))
            {
                System.out.println(s);
                set.add(s);
            }
            return;
        }
        if(i<s1.length())
            findInterLeavings(i+1,j,s1,s2,s+s1.charAt(i),set);
        if(j<s2.length())
            findInterLeavings(i,j+1,s1,s2,s+s2.charAt(j),set);
    }
}
