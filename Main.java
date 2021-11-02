import java.util.*;
public class Main {
    public static void main(String[] args) {
        String str1 = "Aadesh Srivastava";
        String str2 = "Vidushi Srivastava";
        System.out.println(str1.length());
        System.out.println(str1.charAt(2));
        System.out.println(str1.codePointAt(0)); //return unicode of character at that index
        System.out.println(str1.codePointBefore(3)); //return unicode of character before that index
        System.out.println(str1.codePointCount(0, 1));
        System.out.println(str1.contentEquals(str2)); //returns true or false, used to compare with string,stringBuffer and stringBuilder unlike .equals()
        System.out.println(str1.compareTo(str2)); //returns lexicographic difference
        System.out.println(str1.compareToIgnoreCase(str2));
        System.out.println(str1.concat(str2));
        char[] charArray = {'a', 'a', 'd', 'e', 's', 'h'};
        String str3 = String.copyValueOf(charArray); //creates the copy of string
        System.out.println(str3);
        System.out.println(str1.endsWith("va")); //returns true or false
        System.out.println(str1.equals(str2)); //returns true or false
        System.out.println(str1.equalsIgnoreCase(str2));
        String str4 = String.format("name is %s", str1); //similar to System.out.printf() but returns a string
        System.out.println(str4);
        String str = "Java";
        byte[] byteArray = str.getBytes();
        System.out.println(Arrays.toString(byteArray)); //o/p => [74, 97, 118, 97]
        String str5 = "Welcome! to GeeksforGeeks";
        char[] destArray = new char[5];
        str5.getChars(2, 6, destArray, 1); //getChars(int str5StartIndex,int str5EndIndex, char[] destArray, int destStartIndex)
        System.out.println(destArray);
        System.out.println(str1.hashCode()); //returns hashcode of string
        System.out.println(str1.indexOf("ad")); //returns first occurrence index of given string in str1 else -1
        System.out.println(str1.indexOf("ad", 2)); //start searching from index 2
        System.out.println(str1.lastIndexOf("va"));
        System.out.println(str1.isEmpty());
        //stringName.matches() ==>regex method to match strings
        System.out.println(str1.replace("Aadesh", "Vidushi")); //returns new string with replaced part
        //.replaceFirst(),.replaceAll() ==>regex method
        String[] arr = str1.split(" "); //splits string
        System.out.println(Arrays.toString(arr));
        System.out.println(str1.substring(0, 11));
        System.out.println(str1.toCharArray());
        //.trim() ==>removes left and right whitespaces
        //.toLowerCase()
        //.toUpperCase()
        //String.valueOf()
        //learn formatting in java
    }
}


