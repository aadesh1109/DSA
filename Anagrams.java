/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Anagrams {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        Map<Character,Integer> map = new HashMap<>();
        while(t-- > 0)
        {
            boolean not = false;
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(s1);
            System.out.println(s2);

            /*if(s1.length()!=s2.length())
                System.out.println("NO");
            else
            {
                for(int i = 0 ; i < s1.length() ; i++)
                {
                    if(!map.containsKey(s1.charAt(i)))
                        map.put(s1.charAt(i),1);
                    else
                    {
                        int v = map.get(s1.charAt(i));
                        map.put(s1.charAt(i),++v);
                    }
                }


                for (char c : map.keySet()) {
                    System.out.println(c + " " + map.get(c));
                }
                System.out.println("***********");

                for(int i = 0 ; i < s2.length() ; i++)
                {
                    if(!map.containsKey(s2.charAt(i)))
                    {
                        System.out.println("NO");
                        not = true;
                        break;
                    }
                    else
                    {
                        int v = map.get(s2.charAt(i));
                        map.put(s2.charAt(i),--v);
                    }

                }

                if(not)
                    continue;

                for (char c : map.keySet()) {
                    System.out.println(c + " " + map.get(c));
                }

                for(char c : map.keySet())
                {
                    if(map.get(c)!=0)
                    {
                        System.out.println("NO");
                        not = true;
                        break;
                    }
                }

                if(not)
                    continue;
                System.out.println("YES");



            }*/

        }
    }
}