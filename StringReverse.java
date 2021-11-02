public class StringReverse {
    public static void main(String[] args) {
        String s = "aadesh";
        System.out.println(reverseString(s));
    }

    private static String reverseString(String s) {
        char[] string = s.toCharArray();
        reverseString(0,string.length-1,string);
        return new String(string);
    }

    private static void reverseString(int i, int j, char[] string) {
        if(i<j)
        {
            char temp = string[i];
            string[i]=string[j];
            string[j]=temp;
            reverseString(i+1,j-1,string);
        }
    }
}
