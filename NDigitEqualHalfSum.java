public class NDigitEqualHalfSum {
    public static void main(String[] args) {
        generate(6);
    }

    private static void generate(int i) {
        generate(0,i,0,"");
    }

    private static void generate(int i, int digit, int sum,String s) {
        if (i==digit)
        {
            if (sum==0)
                System.out.println(s);
            return;
        }

        for (int j = 0; j <=1 ; j++) {
            if (!(i==0 && j==0)) {
                if (i<digit/2)
                    generate(i+1,digit,sum+j,s+j);
                else
                    generate(i+1,digit,sum-j,s+j);
            }

        }

    }
}
