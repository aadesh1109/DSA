/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class RotatedPalindrome {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0)
        {
            String s = sc.nextLine();
            if(s.length()<2)
                System.out.println(1);
            else
            {
                if(isRotatedPalindrome(s.substring(1)+s.charAt(0),s))
                    System.out.println(1);
                else
                    System.out.println(0);
            }
        }
    }

    public static boolean isRotatedPalindrome(String curr, String toCheck ) {

        if (checkPal(curr))
            return true;

        if (curr.equals(toCheck))
            return false;

        return isRotatedPalindrome(curr.substring(1)+curr.charAt(0),toCheck);


    }

    public static boolean checkPal(String str){
        int i = 0;
        int j = str.length()-1;
        while (i<=j)
        {
            if (str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;

    }
}