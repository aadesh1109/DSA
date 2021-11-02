public class NDigitWithGivenSum {
    public static void main(String[] args) {
        generate(5,42);
    }

    private static void generate(int digits , int sum) {
        generate(digits,sum,"");
    }

    private static void generate(int digits , int sum , String s)
    {
        if (digits==0)
        {
            if (sum==0)
                System.out.println(s);
            return;
        }

        for (int j = 0; j<=9; j++) {
            if (j==0 && s.length()==0)
                continue;

            if (sum-j>=0)
                generate(digits-1,sum-j,s+j);
        }
    }
}
