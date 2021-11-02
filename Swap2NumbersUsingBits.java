public class Swap2NumbersUsingBits {
    public static void main(String[] args) {
        int a = 9;
        int b = 7;
        System.out.println(a+" "+b);
        a=a^b;//^ is XOR
        b=a^b;
        a=a^b;
        System.out.println(a+" "+b);
    }
}
