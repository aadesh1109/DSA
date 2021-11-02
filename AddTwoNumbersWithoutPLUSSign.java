// refer this to know better - https://www.youtube.com/watch?v=qq64FrA2UXQ&ab_channel=BackToBackSWE
public class AddTwoNumbersWithoutPLUSSign {
    public static void main(String[] args) {
        int a = 12;
        int b = 9;
        int addition = add(a,b);
        System.out.println(addition);
    }

    private static int add(int a, int b) {
        while ((a&b)>0)
        {
            int carry = a&b;
            int addition = a^b;
            a=carry<<1;
            b=addition;
        }
        return a^b;
    }
}
