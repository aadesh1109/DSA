public class FindithBitOfNumber {
    public static void main(String[] args) {

        int number = 309;
        int i = 7;
        if ((number&(1<<i))>0)
            System.out.println("Bit is 1 at "+ i);
        else
            System.out.println("Bit is 0 at "+ i);
    }
}
