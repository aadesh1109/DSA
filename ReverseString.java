public class ReverseString {
    public static void main(String[] args) {
        String s = "techie Delight";
        String reversed = reverse(s);
        System.out.println(reversed);
    }

    private static String reverse(String s) {
        char[] c = s.toCharArray();
        reverse(0,c.length-1,c);
        return new String(c);
    }

    private static void reverse(int i, int j, char[] c) {
        if (i>=j)
            return;

            swap(i,j,c);
            reverse(i+1,j-1,c);


    }

    private static void swap(int i, int j, char[] c) {
        char temp = c[i];
        c[i]=c[j];
        c[j]=temp;
    }
}
