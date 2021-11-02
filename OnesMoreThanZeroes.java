public class OnesMoreThanZeroes {
    public static void main(String[] args) {
        generate(6,"");
    }

    private static void generate(int i , int zeros , int ones , String s) {
        if (i==0)
        {
            System.out.println(s);return;
        }
        for (char ch = '1'; ch >= '0' ; ch--) {
            if (ch=='0')
            {
                if (zeros+1<=ones)
                    generate(i-1,zeros+1,ones,s+ch);
            }
            else
                generate(i-1,zeros,ones+1,s+ch);

        }
    }

    private static void generate(int i , String s){
        generate(i,0,0,s);

    }
}
