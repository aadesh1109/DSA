public class ClearithBitOfNumber {
    public static void main(String[] args) {
        int number = 309;
        int i = 8;
        int num = number & (~(1 << i));
        System.out.println(num);
    }
}
