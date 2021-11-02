public class GenerateNDigitNumbersWithEQUAL_ODD_EVEN_INDICES_SUM {
    public static void main(String[] args) {
        int n = 5;
        generate(n);
    }

    private static void generate(int n) {
        generate(n,"",0,0);
    }

    private static void generate(int n, String s, int oddDigitSum, int evenDigitSum) {
        if (n==0)
        {
            if (oddDigitSum==evenDigitSum)
                System.out.println(s);
            return;
        }

        for (int i = 0; i <= 9 ; i++) {
            if (i==0 && s.length()==0)
                continue;
            if (n%2==0)
                generate(n-1,s+i,oddDigitSum,evenDigitSum+i);
            else
                generate(n-1,s+i,oddDigitSum+i,evenDigitSum);
        }
    }

}
