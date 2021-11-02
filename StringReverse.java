import java.util.Arrays;

public class StringReverse {
    public static void main(String[] args) {
        String original = "aadesh";
        reverse(original);
    }

    private static void reverse(String original) {
    reverse(0,original.length()-1,original.toCharArray());
    }

    private static void reverse(int l , int h , char[] ch) {


        if (l>h)
        {
            System.out.println(Arrays.toString(ch));
            return;
        }

        char temp = ch[l];
        ch[l]=ch[h];
        ch[h]=temp;
        reverse(l+1,h-1,ch);


    }

}
