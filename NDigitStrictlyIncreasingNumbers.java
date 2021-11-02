public class NDigitStrictlyIncreasingNumbers {
    public static void main(String[] args) {
        generate(8);
    }

    private static void generate(int i) {
        generate(i,"");
    }

    private static void generate(int i , String str) {
       if (i==0)
       {
           System.out.println(str);
           return;
       }

        for (int j = 1; j<=9 ; j++) {
            if (str.length()==0)
                generate(i-1,str+j);
            else
            {
                if ((int)str.charAt(str.length()-1)<String.valueOf(j).charAt(0))
                    generate(i-1,str+j);
            }

        }
    }
}
