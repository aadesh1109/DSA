public class SetithBitOfNumber {
    public static void main(String[] args) {
        int number = 309;
        int i = 1;
        number = number|(1<<i);
        System.out.println(number);
    }
}
