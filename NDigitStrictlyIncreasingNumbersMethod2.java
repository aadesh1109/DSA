public class NDigitStrictlyIncreasingNumbersMethod2 {
    public static void main(String[] args) {
        generate(8,"",0);
    }

    private static void generate(int i, String s, int prev) {
        if (i==0)
        {
            System.out.println(s);
            return;
        }

        for (int j = prev+1; j <=9 ; j++) {
            generate(i-1,s+j,j);
        }
    }
}
