
public class Compression {
    public static void main(String[] args) {
        String s = "ab";
        int i = 0;
        while (i<s.length())
        {
            char c = s.charAt(i);
            int count = 1;

            while (i+1<s.length() && s.charAt(i)==s.charAt(i+1))
            {
                count++;
                i++;
            }
            System.out.print(c+""+count);
            i++;


        }

    }
}
